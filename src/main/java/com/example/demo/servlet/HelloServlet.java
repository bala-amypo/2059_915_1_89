package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Simple Hello Servlet
 * Used to demonstrate Servlet + Tomcat concepts
 */
@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println("Hello from Smart Invoice Application Servlet!");
    }
}
