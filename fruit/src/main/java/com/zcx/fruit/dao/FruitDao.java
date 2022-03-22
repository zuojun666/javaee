package com.zcx.fruit.dao;

import com.zcx.fruit.domain.Fruit;
import com.zcx.fruit.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FruitDao {
    public List<Fruit> list() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        ArrayList<Fruit> fruits = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from fruit");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Fruit fruit = new Fruit();
            fruit.setFid(resultSet.getInt("fid"));
            fruit.setFname(resultSet.getString("fname"));
            fruit.setFcount(resultSet.getInt("fcount"));
            fruit.setPrice(resultSet.getDouble("price"));
            fruit.setRemark(resultSet.getString("remark"));
            fruits.add(fruit);
        }
        return fruits;
    }

    public int deleteById(Integer id) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from fruit where fid = ?");
        statement.setInt(1, id);
        return statement.executeUpdate();
    }

    public int updateById(Fruit fruit) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("update fruit set fname = ?,fcount = ?,remark = ?,price = ? where fid = ?");
        statement.setString(1, fruit.getFname());
        statement.setInt(2, fruit.getFcount());
        statement.setString(3, fruit.getRemark());
        statement.setDouble(4, fruit.getPrice());
        statement.setInt(5, fruit.getFid());
        return statement.executeUpdate();
    }

    public int addFruit(Fruit fruit) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into fruit values (null,?,?,?,?)");
        statement.setString(1, fruit.getFname());
        statement.setInt(2, fruit.getFcount());
        statement.setDouble(3, fruit.getPrice());
        statement.setString(4, fruit.getRemark());
        return statement.executeUpdate();
    }
}
