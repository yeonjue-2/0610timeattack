package com.sparta.time0610.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserRequestDto {
    private String email;
    private String name;
    private int age;
    private int gender;

//    public UserRequestDto(String email, String name, int age, int gender) {
//        this.email = email;
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//    }
}
