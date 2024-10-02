package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;

public interface MyHandlerAdapter {

    boolean supports(Object handler);

    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}

