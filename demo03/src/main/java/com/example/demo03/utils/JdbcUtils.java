package com.example.demo03.utils;

import java.sql.Connection;

public class JdbcUtils {
    private static Connection connection;
    static {

    }
    public static Connection getConnection(){
        return connection;
    }
}
