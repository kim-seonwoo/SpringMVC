package sunnyToy.sunnyToy.dto.request;

import lombok.*;
import sunnyToy.sunnyToy.enums.*;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private CharacterImage characterImage;
}
