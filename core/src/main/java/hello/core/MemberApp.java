package hello.core;

import hello.core.member.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

public class MemberApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        Spring 컨테이너를 이용해서 찾아옴
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(findMember.getName() + findMember.getName());
    }
}
