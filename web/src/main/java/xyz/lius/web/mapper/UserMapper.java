package xyz.lius.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.lius.web.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}
