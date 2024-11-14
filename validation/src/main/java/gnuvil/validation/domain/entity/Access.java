package gnuvil.validation.domain.entity;

import gnuvil.validation.enums.ControlLevel;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Access {

    @Enumerated(value = EnumType.STRING)
    private ControlLevel level;
}
