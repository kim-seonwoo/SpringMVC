package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v2.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}

