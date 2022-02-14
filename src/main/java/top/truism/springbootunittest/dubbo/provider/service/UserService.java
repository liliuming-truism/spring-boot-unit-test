package top.truism.springbootunittest.dubbo.provider.service;

import top.truism.springbootunittest.dto.UserDTO;

import java.util.List;

public interface UserService {

    Long addUser(UserDTO userDTO);

    UserDTO getByUserId(Long userId);

    List<UserDTO> findAllUsers();

}
