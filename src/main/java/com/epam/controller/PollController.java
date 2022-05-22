package com.epam.controller;

import com.epam.dao.impl.AnswerDAOImpl;
import com.epam.dao.impl.QuestionDAOImpl;
import com.epam.model.Answer;
import com.epam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/poll")
public class PollController {

    private QuestionDAOImpl questionDAO;
    private AnswerDAOImpl answerDAO;

    @Autowired
    public PollController(QuestionDAOImpl questionDAO, AnswerDAOImpl answerDAO) {
        this.questionDAO = questionDAO;
        this.answerDAO = answerDAO;
    }

    @GetMapping("/Aaron-Beck")
    public String aaronBeck(Model model) {
        List<Question> allQuestions = questionDAO.findAll();
        List<Answer> allAnswers = answerDAO.findAll();
        model.addAttribute("questions", allQuestions);
        model.addAttribute("answers", allAnswers);
        return "process/aaronBeck";
    }
}
