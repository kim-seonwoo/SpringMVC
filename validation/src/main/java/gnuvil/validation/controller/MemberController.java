package gnuvil.validation.controller;

import gnuvil.validation.domain.entity.Member;
import gnuvil.validation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
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
    public ResponseEntity<Member> addMember(@ModelAttribute Member member) {
        Member savedMember = memberService.createMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }


    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/createMember")
    public String createMemberForm() {
        return "CreateMember";
    }

    @GetMapping("/myPage/{memberId}")
    public String getMyPage(@PathVariable Long memberId, Model model) {
        Member member = memberService.getMemberById(memberId);
        model.addAttribute("member", member);
        return "myPage";
    }
}