package sunnyToy.sunnyToy.enums;

import lombok.*;

@Getter
@AllArgsConstructor
public enum CharacterImage {
    DOG("강아지"),
    CAT("고양이"),
    FOX("여우");

    private final String name;
}
