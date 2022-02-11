package top.truism.springbootunittest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.truism.springbootunittest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
