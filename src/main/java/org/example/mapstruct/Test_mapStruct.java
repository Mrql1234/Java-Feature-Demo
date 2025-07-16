package org.example.mapstruct;

import java.time.LocalDateTime;

public class Test_mapStruct {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
        user.setCreatedAt(LocalDateTime.now());


        // UserDto dto = mapper2.toDto(user);
        //UserDto dto = UserMapper.INSTANCE.toDto(user);

//        System.out.println("ID: " + dto.getId());
//        System.out.println("Name: " + dto.getName());
//        System.out.println("Email Address: " + dto.getEmailAddress());
//        System.out.println("Formatted Create Time: " + dto.getFormattedCreateTime());
    }
}
