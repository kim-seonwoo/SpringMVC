package gnuvil.validation.enums;

import lombok.*;

@Getter
@AllArgsConstructor
public enum ControlLevel {
    ADMIN("관리자"),
    NORMAL("일반회원");

    private final String name;
}