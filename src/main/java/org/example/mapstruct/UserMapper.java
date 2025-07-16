//package org.example.mapstruct;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@Mapper
//public interface UserMapper {
//
//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
//
//    @Mapping(source = "username", target = "name")
//    @Mapping(source = "email", target = "emailAddress")
//    @Mapping(target = "formattedCreateTime", expression = "java( formatDateTime(user.getCreatedAt()) )")
//    UserDto toDto(User user);
//
//    default String formatDateTime(LocalDateTime dateTime) {
//        return dateTime != null ? dateTime.format(DateTimeFormatter.ISO_DATE_TIME) : null;
//    }
//}
