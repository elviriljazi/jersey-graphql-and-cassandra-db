package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.GraphQLRequest;
import org.example.services.GraphQLProvider;

@Path("graphql")
public class MainResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String query(String payload) throws Exception {
        GraphQLRequest graphQLRequest = new ObjectMapper().readValue(payload, GraphQLRequest.class);
        return new GraphQLProvider().execute(graphQLRequest.query());
    }
}
