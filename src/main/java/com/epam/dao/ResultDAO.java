package com.epam.dao;

import com.epam.model.Result;
import com.epam.model.Text;

import java.util.List;


public interface ResultDAO {
    List<Result> findAll();
    Result findById(Integer id);
    List<Result> findByPollId(Integer id);
    Text findByScore(Integer minScore, Integer maxScore);
}
