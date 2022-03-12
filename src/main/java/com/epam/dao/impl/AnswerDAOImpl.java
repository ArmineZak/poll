package com.epam.dao.impl;

import com.epam.config.DBConnectionProvider;
import com.epam.dao.AnswerDAO;
import com.epam.model.Answer;
import com.epam.model.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAOImpl implements AnswerDAO {

    private Connection connection;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    private PreparedStatement findTextByQuestionId;


    public AnswerDAOImpl() {
        try {
            connection = DBConnectionProvider.getInstance().getConnection();
            findAll = connection.prepareStatement("SELECT * FROM answer");
            findById = connection.prepareStatement("SELECT * FROM answer WHERE answer_id = ?");
            findTextByQuestionId = connection.prepareStatement("SELECT text FROM answer WHERE question_id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Answer> findAll() {
        try (ResultSet resultSet = findAll.executeQuery()) {
            List<Answer> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Answer(
                        resultSet.getInt("answer_id"),
                        resultSet.getString("text"),
                        resultSet.getString("weight"),
                        resultSet.getInt("question_id")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Answer findById(Integer id) {
        try {
            findById.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet resultSet = findById.executeQuery()) {
            Answer answer = new Answer();
            while (resultSet.next()) {
                answer.setId(resultSet.getInt("answer_id"));
                answer.setText(resultSet.getString("text"));
                answer.setWeight(resultSet.getString("weight"));
                answer.setQuestionId(resultSet.getInt("question_id"));
            }
            return answer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Text> findByQuestionId(Integer id) {
        try {
            findTextByQuestionId.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet resultSet = findTextByQuestionId.executeQuery()) {
            List<Text> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Text(resultSet.getString("text")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
