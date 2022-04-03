package com.epam.dao.impl;

import com.epam.config.DBConnectionProvider;
import com.epam.dao.ResultDAO;
import com.epam.model.Result;
import com.epam.model.Text;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ResultDAOImpl implements ResultDAO {

    private Connection connection;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    private PreparedStatement findByPollId;
    private PreparedStatement findByScore;


    public ResultDAOImpl() {
        try {
            connection = DBConnectionProvider.getInstance().getConnection();
            findAll = connection.prepareStatement("SELECT * FROM result");
            findById = connection.prepareStatement("SELECT * FROM result WHERE result_id = ?");
            findByPollId = connection.prepareStatement("SELECT * FROM result WHERE poll_id = ?");
            findByScore = connection.prepareStatement("SELECT explanation FROM result WHERE min_score =? AND max_score =?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Result> findAll() {
        try (ResultSet resultSet = findAll.executeQuery()) {
            List<Result> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Result(
                        resultSet.getInt("result_id"),
                        resultSet.getString("explanation"),
                        resultSet.getInt("min_score"),
                        resultSet.getInt("max_score"),
                        resultSet.getInt("poll_id")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Result findById(Integer id) {
        try {
            findById.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet resultSet = findById.executeQuery()) {
            Result result = new Result();
            while (resultSet.next()) {
                result.setId(resultSet.getInt("result_id"));
                result.setExplanation(resultSet.getString("explanation"));
                result.setMinScore(resultSet.getInt("min_score"));
                result.setMaxScore(resultSet.getInt("max_score"));
                result.setPollId(resultSet.getInt("poll_id"));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Result> findByPollId(Integer id) {
        try {
            findByPollId.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet resultSet = findByPollId.executeQuery()) {
            List<Result> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Result(
                        resultSet.getInt("result_id"),
                        resultSet.getString("explanation"),
                        resultSet.getInt("min_score"),
                        resultSet.getInt("max_score"),
                        resultSet.getInt("poll_id")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Text findByScore(Integer minScore, Integer maxScore) {
        try {
            findByScore.setInt(1, minScore);
            findByScore.setInt(2, maxScore);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet resultSet = findByScore.executeQuery()) {
            Text result = new Text();
            while (resultSet.next()) {
                result.setText(resultSet.getString("explanation"));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
