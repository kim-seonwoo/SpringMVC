package gnuvil.validation.service;

import gnuvil.validation.domain.entity.*;
import gnuvil.validation.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupService {

    private final GroupJpaRepository groupJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final TimeStampJpaRepository timeStampJpaRepository;

    public Group getGroupById(Long groupId) {
        return groupJpaRepository.findByIdOrThrow(groupId);
    }

    public Group createGroup(Group group) {
        return groupJpaRepository.save(group);
    }

    public void deleteGroup(Long groupId) {
        Group group = groupJpaRepository.findByIdOrThrow(groupId);
        groupJpaRepository.delete(group);
    }

    public TimeStamp createTimeStamp(Long groupId, Long memberId) {
        Group group = groupJpaRepository.findByIdOrThrow(groupId);
        Member member = memberJpaRepository.findByIdOrThrow(memberId);

        TimeStamp timeStamp = TimeStamp.builder()
                .startTime("start_time")  // 여기서 실제 시간 데이터를 설정해야 함
                .endTime("end_time")      // 여기서 실제 시간 데이터를 설정해야 함
                .member(member)
                .build();

        timeStampJpaRepository.save(timeStamp);

        // 그룹의 isAvailable 상태를 toggle
        group.setIsAvailable(!group.getIsAvailable());
        groupJpaRepository.save(group);

        return timeStamp;
    }
}
