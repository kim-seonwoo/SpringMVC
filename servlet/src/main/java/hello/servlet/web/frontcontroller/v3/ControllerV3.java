package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.*;

import java.util.*;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
