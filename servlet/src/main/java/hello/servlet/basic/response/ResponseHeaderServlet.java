package hello.servlet.basic.response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK); //200
        //[response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must- revalidate");
                response.setHeader("Pragma", "no-cache");

        response.setHeader("my-header","hello");
//[Header 편의 메서드]
//content(response);
//cookie(response);
//redirect(response);
        //[message body]
        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }
}