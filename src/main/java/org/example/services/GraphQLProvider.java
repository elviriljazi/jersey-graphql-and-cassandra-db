package org.example.services;

import com.datastax.oss.driver.shaded.guava.common.io.Resources;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.example.models.User;

import java.io.File;

public class GraphQLProvider {

    private final GraphQL graphQL;

    public GraphQLProvider() throws Exception {
        File file = new File(Resources.getResource("schema.graphql").toURI());
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(file);
        UserService service = UserService.getInstance();
        RuntimeWiring wiring = RuntimeWiring
                .newRuntimeWiring()
                .type("Query", builder -> builder
                        .dataFetcher("user", (DataFetcher<User>) environment -> service.get(environment.getArgument("id")))
                        .dataFetcher("users", environment -> service.getAll())
                )
                .type("Mutation", builder -> builder
                        .dataFetcher("user", environment -> service.insert(environment.getArgument("user")))
                )
                .build();

        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);

        graphQL = GraphQL.newGraphQL(schema).build();
    }

    public String execute(String query) throws Exception {
        return new ObjectMapper().writeValueAsString(graphQL.execute(query));
    }
}
