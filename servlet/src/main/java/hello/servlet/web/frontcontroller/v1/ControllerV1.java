package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;

public interface ControllerV1 {
    void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}