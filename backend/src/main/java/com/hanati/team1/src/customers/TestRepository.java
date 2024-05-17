package com.hanati.team1.src.customers;

import com.hanati.team1.src.customers.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * JPA 방식 적용
 * 기본 제공 쿼리 : findBy컬럼명
 * 커스텀 쿼리 : @Query 어노테이션 사용
 */
public interface TestRepository extends JpaRepository<User, Long> {
    User findById(long id);

    List<User> findByStatus(String status);
    List<User> findByStatusAndNicknameIsContaining(String status, String word);

    @Query("SELECT t FROM Test t")
    List<User> getTestEntityList();
}