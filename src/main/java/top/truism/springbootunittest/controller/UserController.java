package top.truism.springbootunittest.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.truism.springbootunittest.common.CommonResponse;
import top.truism.springbootunittest.dto.UserDTO;
import top.truism.springbootunittest.service.UserService;
import top.truism.springbootunittest.vo.UserVo;

import javax.annotation.Resource;

@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/create")
    public CommonResponse createUser(@RequestBody UserVo userVo) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userVo, userDTO);
        userService.addUser(userDTO);
        return CommonResponse.success(1001, "success", null);
    }

}
