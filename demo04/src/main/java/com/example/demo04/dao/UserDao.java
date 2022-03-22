package com.example.demo04.dao;

import com.example.demo04.domain.User;
import com.example.demo04.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> list() throws SQLException {
        ArrayList<User> list = new ArrayList<User>();
        Connection connection= JdbcUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from user");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            list.add(user);
        }
        resultSet.close();
        statement.close();
        return list;
    }
}
