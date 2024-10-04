package com.bookSpring.bookSpring.domain;

import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    // SpringDataJpa에서 제공되지 않는 메소드는 쿼리로 작성
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
