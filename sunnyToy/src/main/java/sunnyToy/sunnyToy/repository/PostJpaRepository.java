package sunnyToy.sunnyToy.repository;

import org.springframework.data.jpa.repository.*;
import sunnyToy.sunnyToy.domain.entity.*;

import java.util.*;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);

}