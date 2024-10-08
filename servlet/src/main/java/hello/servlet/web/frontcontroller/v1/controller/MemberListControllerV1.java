package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.*;
import hello.servlet.web.frontcontroller.v1.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;

public class MemberListControllerV1 implements ControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);
        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
