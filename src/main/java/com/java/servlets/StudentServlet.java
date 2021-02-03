package com.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentServlet extends HttpServlet {
    //GET


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); to need to call super
        //we will write own implementation
        PrintWriter writer = resp.getWriter();
        writer.write("Welcome to web app");
    }
}
