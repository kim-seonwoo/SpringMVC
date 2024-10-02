package hello.servlet.web.frontcontroller.v2;


import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v1.*;
import hello.servlet.web.frontcontroller.v1.controller.*;
import hello.servlet.web.frontcontroller.v2.controller.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
 public class FrontControllerServletV2 extends HttpServlet {
     private Map<String, ControllerV2> controllerMap = new HashMap<>();
     public FrontControllerServletV2() {
         controllerMap.put("/front-controller/v1/members/new-form", new
                 MemberFormControllerV2());
         controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV2());
         controllerMap.put("/front-controller/v1/members", new
 MemberListControllerV2());
     }
@Override
     protected void service(HttpServletRequest request, HttpServletResponse
 response)
             throws ServletException, IOException {
         System.out.println("FrontControllerServletV1.service");
         String requestURI = request.getRequestURI();

         ControllerV2 controller = controllerMap.get(requestURI);
         if (controller == null) {
             response.setStatus(HttpServletResponse.SC_NOT_FOUND);
return; }
    MyView view = controller.process(request, response);
         view.render(request, response);
     }
}