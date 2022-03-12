package com.epam.dao.impl;

import com.epam.config.DBConnectionProvider;
import com.epam.dao.QuestionDAO;
import com.epam.model.Answer;
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
            findById = connection.prepareStatement("SELECT question.text, answer.text, answer.weight, answer.question_Id " +
                    " FROM question JOIN answer ON question.question_id=answer.question_id WHERE question.question_id = ?");
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
    public Map<Text, List<Answer>> findById(Integer id) {
        try {
            findById.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet resultSet = findById.executeQuery()) {
            Map<Text, List<Answer>> result = new HashMap<>();
            List<Answer> answers = new ArrayList<>();
            Text question = new Text();
            while (resultSet.next()) {
                question.setText(resultSet.getString("text"));
                answers.add(new Answer(
                        resultSet.getString("answer.text"),
                        resultSet.getString("weight"),
                        resultSet.getInt("question_id")));
            }
            result.put(question, answers);
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
