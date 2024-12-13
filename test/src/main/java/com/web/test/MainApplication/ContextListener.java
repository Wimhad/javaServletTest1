package com.web.test.MainApplication;

import com.web.test.util.DatabaseUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;


@WebListener
public class ContextListener implements ServletContextListener {

    private final DataSource dataSource = DatabaseUtil.getDataSource();

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        // Flyway migrations
        migrateDatabase();


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("AUTH_DATA");
        cleanDatabase();

    }

    private void migrateDatabase() {
        try {
            Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:postgresql://localhost:5433/hi",
                            "postgres",
                            "password")
                    .locations("classpath:db/migration")

                    .baselineOnMigrate(true)
                    .load();
            flyway.migrate();
        } catch (Exception e) {
            throw new RuntimeException("Migration failed", e);
        }
    }

    private void cleanDatabase() {
        // Be very cautious with the following destructive operation
        String query = "DROP SCHEMA public CASCADE; CREATE SCHEMA public;";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(query);
        } catch (Exception e) {
            throw new RuntimeException("Migration failed", e);
        }
    }

}
