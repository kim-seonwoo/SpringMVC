package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;

public interface ControllerV2 {

    MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
