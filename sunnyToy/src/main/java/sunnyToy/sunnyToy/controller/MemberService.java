package sunnyToy.sunnyToy.controller;

import jakarta.persistence.*;
import jakarta.transaction.*;
import lombok.*;
import org.springframework.stereotype.*;
import sunnyToy.sunnyToy.domain.entity.*;
import sunnyToy.sunnyToy.dto.request.*;
import sunnyToy.sunnyToy.dto.response.*;
import sunnyToy.sunnyToy.repository.*;

import java.util.*;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getMemberByIdV1(Long id) {
        Member member = memberJpaRepository.findById(id).get();
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getMemberByIdV2(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다.")));
    }

    public MemberGetResponse getMemberByIdV3(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public String create(MemberCreateRequest request) {
        Member member =  memberJpaRepository.save(Member.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .age(request.getAge())
                .role(request.getRole())
                .build());
        return member.getId().toString();
    }

    @Transactional
    public void updateRole(Long memberId, MemberProfileUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateRole(new Role(request.getGeneration(), request.getCharacterImage()));
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }
}
