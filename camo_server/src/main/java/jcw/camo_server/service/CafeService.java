package jcw.camo_server.service;

import jcw.camo_server.entity.Cafe;
import jcw.camo_server.entity.User;
import jcw.camo_server.mapper.CafeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CafeService {

    private final CafeMapper cafeMapper;
    private final UserService userService;

    /**
     * 카페 등록
     */
    @Transactional
    public Cafe register(Cafe cafe) {
        cafeMapper.cafeSave(cafe);
        Optional<User> optionalUser = userService.findById(cafe.getUserId());
        userService.userRoleUpdate(optionalUser.get());
        return cafe;
    }

    /**
     * 카페 리스트 조회
     */
    public List<Cafe> cafeList() {
        return cafeMapper.findAll();
    }

    /**
     * 검색어가 이름에 포함된 카페 리스트
     */
    @Transactional
    public List<Cafe> findByName(String name) {
        return cafeMapper.findByName(name);
    }


}
