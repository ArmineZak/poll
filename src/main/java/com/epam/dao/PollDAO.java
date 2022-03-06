package com.epam.dao;

import com.epam.model.Poll;

import java.util.List;


public interface PollDAO {
    List<Poll> findAll();
    Poll findById(Integer id);
}
