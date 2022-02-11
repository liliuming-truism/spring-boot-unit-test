package top.truism.springbootunittest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.truism.springbootunittest.dao.UserRepository;
import top.truism.springbootunittest.dto.UserDTO;
import top.truism.springbootunittest.entity.User;
import top.truism.springbootunittest.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public void addUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userRepository.save(user);
    }

    @Override
    public UserDTO getByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        UserDTO userDTO = new UserDTO();
        if (userOptional.isPresent()) {
            BeanUtils.copyProperties(userOptional.get(), userDTO);
        }
        return userDTO;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>(userList.size());
        for (User user : userList) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
