package com.epam.dao.impl;

import com.epam.config.DBConnectionProvider;
import com.epam.dao.PollDAO;
import com.epam.model.Poll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PollDAOImpl implements PollDAO {

    private Connection connection;
    private PreparedStatement findAll;
    private PreparedStatement findById;

    public PollDAOImpl() {
        try {
            connection = DBConnectionProvider.getInstance().getConnection();
            findAll = connection.prepareStatement("SELECT * FROM poll");
            findById = connection.prepareStatement("SELECT * FROM poll WHERE poll_id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Poll findById(Integer id) {
        try {
            findById.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet resultSet = findById.executeQuery()) {
            Poll poll = new Poll();
            while (resultSet.next()) {
                poll.setId(resultSet.getInt("poll_id"));
                poll.setName(resultSet.getString("name"));
                poll.setDescription(resultSet.getString("description"));
            }
            return poll;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Poll> findAll() {
        try (ResultSet resultSet = findAll.executeQuery()) {
            List<Poll> results = new ArrayList<>();
            while (resultSet.next()) {
                results.add(new Poll(
                        resultSet.getInt("poll_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")));
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
