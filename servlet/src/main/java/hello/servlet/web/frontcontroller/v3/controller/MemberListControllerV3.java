package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.*;
import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v3.*;

import java.util.*;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }

}
