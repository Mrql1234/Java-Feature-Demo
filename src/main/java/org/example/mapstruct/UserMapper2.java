package org.example.mapstruct;

import org.mapstruct.Mapping;

public abstract class UserMapper2 {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "name")
    @Mapping(source = "email", target = "emailAddress")
    @Mapping(source = "createdAt", target = "formattedCreateTime")
    public abstract UserDto toDto(User user);
}
