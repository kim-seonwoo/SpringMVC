package sunnyToy.sunnyToy.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import sunnyToy.sunnyToy.enums.*;

@Embeddable // @Embedded랑 세트!
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Role {
    private int generation;

    @Enumerated(value = EnumType.STRING) // 이걸 붙여주셔야 Part의 변수명으로 저장이 됩니다
    private CharacterImage part;
}