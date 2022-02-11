package top.truism.springbootunittest.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDTO {

    private Long id;

    private String username;

    private String password;

}
