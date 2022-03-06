package com.epam.dao.impl;

import com.epam.config.DBConnectionProvider;
import com.epam.dao.QuestionDAO;
import com.epam.model.Question;
import com.epam.model.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDAOImpl implements QuestionDAO {

    private Connection connection;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    private PreparedStatement findTextByPollId;


    public QuestionDAOImpl() {
        try {
            connection = DBConnectionProvider.getInstance().getConnection();
            findAll = connection.prepareStatement("SELECT question_id, text FROM question");
            findById = connection.prepareStatement("SELECT question.question_id, answer.text FROM question " +
                    "JOIN answer ON question.question_id=answer.question_id WHERE question.question_id = ?");
            findTextByPollId = connection.prepareStatement("SELECT text FROM question WHERE poll_id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Question> findAll() {
        try (ResultSet resultSet = findAll.executeQuery()) {
            List<Question> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Question(
                        resultSet.getInt("question_id"),
                        resultSet.getString("text")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<Integer, List<Text>> findById(Integer id) {
        try {
            findById.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet resultSet = findById.executeQuery()) {
            Map<Integer, List<Text>> result = new HashMap<>();
            List<Text> answers = new ArrayList<>();
            while (resultSet.next()) {
                answers.add(new Text(resultSet.getString("text")));
            }
            result.put(id, answers);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Text> findByPollId(Integer id) {
        try {
            findTextByPollId.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet resultSet = findTextByPollId.executeQuery()) {
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
