package gnuvil.validation.repository;

import gnuvil.validation.domain.entity.TimeStamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeStampJpaRepository extends JpaRepository<TimeStamp, Long> {
}
