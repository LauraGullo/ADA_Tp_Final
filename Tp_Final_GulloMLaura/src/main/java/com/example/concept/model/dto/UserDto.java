package com.example.concept.model.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {
    private Long idUser;
    private String name;
    private String password;
    private String mail;
    private Long phone;
}
