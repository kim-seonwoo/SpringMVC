package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v5.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.web.servlet.*;

import java.io.*;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return false;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        return null;
    }
}
