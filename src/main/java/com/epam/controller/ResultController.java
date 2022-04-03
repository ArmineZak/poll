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

    @GetMapping("/Aaron-Beck")
    public String aaronBeckResult(@RequestParam Map<String, String> map,
                                  Model model) {
        int score = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            int num = Integer.parseInt(String.valueOf(entry.getValue()));
            score += num;
        }

        if (score >= 30 && score <= 63) {
            text = result.findByScore(30, 63);
        } else if (score >= 20 && score <= 29) {
            text = result.findByScore(20, 29);
        } else if (score >= 16 && score <= 19) {
            text = result.findByScore(16, 19);
        } else if (score >= 10 && score <= 15) {
            text = result.findByScore(10, 15);
        } else {
            text = result.findByScore(0, 9);
        }

        model.addAttribute("result", text);
        return "result/result";
    }
}

