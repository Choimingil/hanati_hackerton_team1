package com.hanati.team1.src.matches.repositories;

import com.hanati.team1.src.matches.entities.GoalKeeperRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalKeeperRecordRepository extends JpaRepository<GoalKeeperRecord,Long> {
}
