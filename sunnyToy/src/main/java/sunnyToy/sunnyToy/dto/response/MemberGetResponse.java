package sunnyToy.sunnyToy.dto.response;

import sunnyToy.sunnyToy.domain.entity.*;

public record MemberGetResponse(
        String name,
        String nickname,
        int age,
        Role role
) {
    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getRole()
        );
    }
}
