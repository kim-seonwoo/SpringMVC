package gnuvil.validation.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.beans.ConstructorProperties;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
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

