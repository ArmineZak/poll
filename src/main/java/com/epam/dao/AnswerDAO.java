package com.epam.dao;

import com.epam.model.Answer;
import com.epam.model.Text;

import java.util.List;
import java.util.Map;

public interface AnswerDAO {
    List<Answer> findAll();
    Answer findById(Integer id);
    List<Text> findByQuestionId(Integer id);
}
