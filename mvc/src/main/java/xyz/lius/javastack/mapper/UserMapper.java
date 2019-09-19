package xyz.lius.javastack.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.lius.javastack.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
}
