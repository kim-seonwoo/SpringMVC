package gnuvil.validation.repository;

import gnuvil.validation.domain.entity.*;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.*;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다."));
    }
}