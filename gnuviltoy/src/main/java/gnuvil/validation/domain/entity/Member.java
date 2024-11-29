package gnuvil.validation.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.beans.ConstructorProperties;

@Entity
@Getter
@Setter
@NoArgsConstructor()
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "이름은 필수 항목입니다.") // 빈 문자열 방지
    @Size(max = 50, message = "이름은 50자 이내로 입력해야 합니다.")
    private String name;

    @Embedded
    @NotNull
    private Access access;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Builder
    @ConstructorProperties({"id", "name", "access", "group"})
    public Member(Long id, String name, Access access, Group group) {
        this.id = id;
        this.name = name;
        this.access = access;
        this.group = group;
    }
}

