package com.epam.controller;

import com.epam.dao.impl.ResultDAOImpl;
import com.epam.model.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/result")
public class ResultController {
    private ResultDAOImpl result;
    private Text text;

    @Autowired
    public ResultController(ResultDAOImpl result) {
        this.result = result;
    }

    @PostMapping("/Aaron-Beck")
    public String aaronBeckResult(@RequestParam Map<String, String> map,
                                  Model model) {
        int score = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            int num = Integer.parseInt(String.valueOf(entry.getValue()));
            score += num;
        }

        text = result.findByScore(score);
        model.addAttribute("result", text);
        return "result/result";
    }
}

