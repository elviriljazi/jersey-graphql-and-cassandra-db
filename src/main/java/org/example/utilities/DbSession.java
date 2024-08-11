package org.example.utilities;


import com.datastax.oss.driver.api.core.CqlSession;

public class DbSession {

    public static CqlSession getSession() {
        return CqlSession.builder().withKeyspace("schema1").build();
    }
}
