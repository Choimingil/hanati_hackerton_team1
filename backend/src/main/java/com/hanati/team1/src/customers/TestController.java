package com.hanati.team1.src.customers;

import com.hanati.team1.bases.BaseResponse;
import com.hanati.team1.src.customers.entities.User;
import com.hanati.team1.src.customers.models.PostTestReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hanati.team1.bases.BaseResponseStatus.*;

/**
 * 각 메서드 내에서 벨리데이션 진행
 * 다른 도메인 작업이 필요할 경우 서비스 가져와서 작업 수행
 * 되도록이면 로직 처리는 컨트롤러가 아닌 서비스에서 실행
 * *************************************************************************************************************
 * 주의!!!! 해커톤이기 때문에 로그인 기능 미구현, 따라서 GET 메서드 시 헤더에 데이터 넣지 않고 쿼리스트링으로 파라미터 받아서 진행
 * *************************************************************************************************************
 */
@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    /**
     * POST 메서드
     * @return
     */
    @PostMapping("/{domain_name}")
    public BaseResponse<Long> postTest(@RequestBody PostTestReq req){
        // params type 및 return type에 맞게 수정하여 사용
        return new BaseResponse<>(SUCCESS_POST_USER,testService.create());
    }

    /**
     * PUT 메서드
     * @return
     */
    @PutMapping("/{domain_name}")
    public <T> BaseResponse<Boolean> putTest(
            @RequestBody PostTestReq req,
            @RequestParam(name="id",required = true) long id
    ){
        // params type 및 return type에 맞게 수정하여 사용
        return new BaseResponse<>(SUCCESS_PATCH_USER, testService.update(req,id));
    }

    /**
     * DELETE 메서드
     * @return
     */
    @DeleteMapping("/{domain_name}")
    public BaseResponse<Boolean> deleteTest(@RequestParam(name="id",required = true) long id){
        // params type 및 return type에 맞게 수정하여 사용
        return new BaseResponse<>(SUCCESS_DELETE_USER, testService.delete(id));
    }

    /**
     * GET 메서드 (리스트 타입 반환)
     * @return
     */
    @GetMapping("/{domain_name}")
    public BaseResponse<List<User>> getListTest(){
        // params type 및 return type에 맞게 수정하여 사용
        return new BaseResponse<>(SUCCESS_READ_USERS,testService.getList());
    }

    /**
     * GET 메서드 (단일 타입 반환)
     * @return
     */
    @GetMapping("/{domain_name}")
    public BaseResponse<User> getDetailTest(@RequestParam(name="id",required = true) long id){
        // params type 및 return type에 맞게 수정하여 사용
        return new BaseResponse<>(SUCCESS_READ_USER,testService.getDetail(id));
    }
}
