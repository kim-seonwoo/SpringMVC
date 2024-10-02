package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v3.*;

import java.util.*;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
