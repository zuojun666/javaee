package com.zcx.fruit.utils;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        System.out.println();
    }
    /**

     * @return: java.sql.Connection
     * @author: Administrator
     * @date: 2022/3/22 11:33
     * @description:
     */
    public static Connection getConnection(){
        return connection;
    }
}
