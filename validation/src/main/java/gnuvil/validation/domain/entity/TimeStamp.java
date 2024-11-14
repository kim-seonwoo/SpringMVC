package gnuvil.validation.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "timeStamp")
public class TimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeStampId;

    private String startTime;
    private String endTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public TimeStamp(String startTime, String endTime, Member member) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.member = member;
    }
}
