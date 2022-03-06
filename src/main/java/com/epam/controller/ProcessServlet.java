package com.epam.controller;

import com.epam.dao.impl.ResultDAOImpl;
import com.epam.model.Text;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class ProcessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] paramValue;
        int score = 0;
        Enumeration paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            paramValue = req.getParameterValues(paramName);
            for (int i = 0; i < paramValue.length; i++) {
                int num = Integer.parseInt(String.valueOf(paramValue[i]));
                score += num;
            }
        }

        Text text;
        ResultDAOImpl result = new ResultDAOImpl();
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

        req.setAttribute("result", text);
        req.getRequestDispatcher("result.jsp").forward(req, resp);


    }
}
