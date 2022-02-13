package com.alevelhw.module3;

import com.alevelhw.module3.service.UserActionService;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/stock";
        String user = "postgres";
        String password = "root";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Flyway flyway = Flyway
                .configure()
                .dataSource(url, user, password)
                .load();

        flyway.clean();
        flyway.migrate();

        UserActionService userActionService = new UserActionService();
        userActionService.doActions();
    }
}
