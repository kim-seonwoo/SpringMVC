package gnuvil.validation.controller;

import gnuvil.validation.domain.entity.*;
import gnuvil.validation.service.MemberService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMemberProfile(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMemberById(memberId));
    }

    @PostMapping
    public String addMember(@Validated @ModelAttribute Member member, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("member", member);
            return "CreateMember";
        }
        // 성공적으로 회원을 생성한 후
        memberService.createMember(member);
        // 생성된 회원의 ID로 마이페이지로 리다이렉트
        return "redirect:/api/member/myPage/" + member.getId();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/createMember")
    public String createMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "CreateMember";
    }


    @GetMapping("/myPage/{memberId}")
    public String getMyPage(@PathVariable Long memberId, Model model) {
        Member member = memberService.getMemberById(memberId);
        model.addAttribute("member", member);
        return "myPage";
    }
}