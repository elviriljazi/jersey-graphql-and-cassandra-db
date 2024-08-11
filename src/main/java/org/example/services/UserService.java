package org.example.services;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import org.example.utilities.DbSession;
import org.example.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {

    public static UserService getInstance() {
        return new UserService();
    }

    public User get(String id) {
        try (CqlSession session = DbSession.getSession()) {
            ResultSet rs = session.execute("select * from users where id=?;", id);
            for (Row row : rs) {
                return new User(row);
            }
        }
        return null;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (CqlSession session = DbSession.getSession()) {
            ResultSet rs = session.execute("select * from users;");
            for (Row row : rs) {
                users.add(new User(row));
            }
        }
        return users;
    }

    public Map<String, String> insert(Map<String, String> user) {
        if (user == null) {
            return null;
        }
        try (CqlSession session = DbSession.getSession()) {
            session.execute("insert into users (name, email, phone, id) values (?, ?, ?, ?);",
                    user.get("name"), user.get("email"), user.get("phone"), user.get("id"));
        }

        return user;
    }
}
