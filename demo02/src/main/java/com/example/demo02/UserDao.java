package com.example.demo02;

import java.sql.*;

public class UserDao {
    public boolean add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(?,?)");
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getPassword());
        return preparedStatement.execute();
    }
}
