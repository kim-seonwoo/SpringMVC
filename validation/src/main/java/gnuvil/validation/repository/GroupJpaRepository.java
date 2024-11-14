package gnuvil.validation.repository;

import gnuvil.validation.domain.entity.Group;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupJpaRepository extends JpaRepository<Group, Long> {
    default Group findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 그룹입니다."));
    }
}
