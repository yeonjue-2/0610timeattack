package com.sparta.time0610.service;

import com.sparta.time0610.domain.User;
import com.sparta.time0610.domain.UserRepository;
import com.sparta.time0610.domain.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional  // DB에 반영이 꼭 되게끔
    public Long update(Long id, UserRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        user.update(requestDto);
        return user.getId();
    }
}
