package com.hanati.team1.src.domain1;

import com.hanati.team1.src.domain1.entities.TestEntity;
import com.hanati.team1.src.domain1.models.PostTestReq;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    /**
     * DB Create, 아이디 리턴
     * @return
     */
    @Transactional
    public long create(){
        TestEntity entity = testRepository.save(new TestEntity());
        return entity.getId();
    }

    /**
     * DB Update
     */
    @Transactional
    public boolean update(PostTestReq req, long id){
        TestEntity entity = testRepository.findById(id);
        entity.setEmail(req.getEmail());
        entity.setPassword(req.getPassword());
        return true;
    }

    /**
     * DB Delete
     */
    @Transactional
    public boolean delete(long id){
        TestEntity entity = testRepository.findById(id);
        testRepository.delete(entity);
        return true;
    }

    /**
     * DB Select, 리스트 조회 시
     * @return
     */
    public List<TestEntity> getList(){
        return testRepository.getTestEntityList();
    }

    /**
     * DB Select, 하나의 아이템 조회 시
     * @return
     */
    public TestEntity getDetail(long id){
        return testRepository.findById(id);
    }
}
