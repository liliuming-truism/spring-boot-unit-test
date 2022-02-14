package top.truism.springbootunittest.service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import top.truism.springbootunittest.dao.UserRepository;
import top.truism.springbootunittest.dto.UserDTO;
import top.truism.springbootunittest.entity.User;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDubbo(scanBasePackages = "top.truism.springbootunittest")
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        Matchers.equalTo(1L).matches(userService.addUser(userDTO));
    }

    private void initDbBeforeTest() {

    }

}
