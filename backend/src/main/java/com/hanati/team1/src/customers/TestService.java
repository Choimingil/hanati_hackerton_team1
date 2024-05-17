package com.hanati.team1.src.customers;

import com.hanati.team1.src.customers.entities.User;
import com.hanati.team1.src.customers.models.PostTestReq;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        User entity = testRepository.save(new User());
        return entity.getUserId();
    }

    /**
     * DB Update
     */
    @Transactional
    public boolean update(PostTestReq req, long id){
        User entity = testRepository.findByUserId(id);
        entity.setUserName(req.getUserName());
        return true;
    }

    /**
     * DB Delete
     */
    @Transactional
    public boolean delete(long id){
        User entity = testRepository.findByUserId(id);
        testRepository.delete(entity);
        return true;
    }

    /**
     * DB Select, 리스트 조회 시
     * @return
     */
    public List<User> getList(){
        return testRepository.getTestEntityList();
    }

    /**
     * DB Select, 하나의 아이템 조회 시
     * @return
     */
    public User getDetail(long id){
        return testRepository.findByUserId(id);
    }
}
