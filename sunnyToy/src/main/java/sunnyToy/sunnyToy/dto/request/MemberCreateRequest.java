package sunnyToy.sunnyToy.dto.request;

import lombok.*;
import sunnyToy.sunnyToy.domain.entity.*;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private Role role;
}