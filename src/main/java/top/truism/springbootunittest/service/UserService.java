package top.truism.springbootunittest.service;

import top.truism.springbootunittest.dto.UserDTO;

import java.util.List;

public interface UserService {

    Long addUser(UserDTO userDTO);

    UserDTO getByUserId(Long userId);

    List<UserDTO> findAllUsers();

}
