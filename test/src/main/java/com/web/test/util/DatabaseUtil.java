package com.web.test.util;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtil {

        private static final HikariDataSource dataSource;

        static {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://localhost:5433/hi");
            config.setUsername("postgres");
            config.setPassword("password");
            config.setDriverClassName("org.postgresql.Driver");

            dataSource = new HikariDataSource(config);
        }

        public static DataSource getDataSource() {
            return dataSource;
        }

        public static Connection getConnection() throws SQLException {
            return dataSource.getConnection();
    }

}
