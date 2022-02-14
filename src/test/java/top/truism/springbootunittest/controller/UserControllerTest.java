package top.truism.springbootunittest.controller;


import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import top.truism.springbootunittest.dao.UserRepository;
import top.truism.springbootunittest.entity.User;
import top.truism.springbootunittest.vo.UserVo;

import javax.annotation.Resource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
public class UserControllerTest extends BaseControllerTest {

    @Resource
    private UserRepository userRepository;

    @Resource
    private MockMvc mockMvc;

    @After
    public void resetDb() {
        userRepository.deleteAll();
    }

    @Test
    public void testAddUser() throws Exception {
        UserVo userVo = new UserVo();
        userVo.setUsername("jacob");
        userVo.setPassword("123456");
        mockMvc.perform(post("/user/create").contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(userVo)));

        User user = userRepository.findByUsername("jacob");
        User expectUser = new User();
        expectUser.setUsername("jacob");
        expectUser.setPassword("123456");
        assertThat(user).isEqualTo(expectUser);
    }

}
