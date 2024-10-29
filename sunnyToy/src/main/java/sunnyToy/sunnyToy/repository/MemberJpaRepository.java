package sunnyToy.sunnyToy.repository;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.*;
import sunnyToy.sunnyToy.domain.entity.*;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다."));
    }
}
