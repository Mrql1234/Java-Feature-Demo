package org.example.mapstruct;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String emailAddress;
    private String formattedCreateTime;

}
