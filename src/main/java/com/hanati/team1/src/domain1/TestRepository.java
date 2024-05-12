package com.hanati.team1.src.domain1;

import com.hanati.team1.src.domain1.entities.TestEntity;
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
public interface TestRepository extends JpaRepository<TestEntity, Long> {
    TestEntity findById(long id);

    List<TestEntity> findByStatus(String status);
    List<TestEntity> findByStatusAndNicknameIsContaining(String status, String word);

    @Query("SELECT t FROM Test t")
    List<TestEntity> getTestEntityList();
}