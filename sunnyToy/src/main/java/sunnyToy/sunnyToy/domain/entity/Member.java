package sunnyToy.sunnyToy.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import sunnyToy.sunnyToy.domain.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private int age;
    private Role role; // Role 필드 추가

    public void updateRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        this.role = role; // role 필드를 업데이트
    }
}

