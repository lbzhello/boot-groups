package xyz.lius.mvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.lius.mvc.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
}
