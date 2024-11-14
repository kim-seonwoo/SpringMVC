package gnuvil.validation.service;

import gnuvil.validation.domain.entity.Member;
import gnuvil.validation.repository.MemberJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public Member getMemberById(Long memberId) {
        return memberJpaRepository.findByIdOrThrow(memberId);
    }

    public Member createMember(Member member) {
        return memberJpaRepository.save(member);
    }

    public void deleteMember(Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }
}
