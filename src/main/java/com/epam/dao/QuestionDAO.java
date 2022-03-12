package com.epam.dao;

import com.epam.model.Answer;
import com.epam.model.Question;
import com.epam.model.Text;

import java.util.List;
import java.util.Map;

public interface QuestionDAO {
    List<Question> findAll();
    Map<Text, List<Answer>> findById(Integer id);
    List<Text> findByPollId(Integer id);
}
