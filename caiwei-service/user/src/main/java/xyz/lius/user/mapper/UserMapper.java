package xyz.lius.user.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.lius.api.user.User;

import java.util.List;

public interface UserMapper {
    List<User> findList();

    @Select("select * from user where user_id = #{id}")
    User findById(int id);

    @Select("select * from user where user_name = #{name}")
    User findByName(String name);

    @Insert("select user_id from user")
    void create(User user);

    @Update("select user_id from user")
    void update(User user);

    @Delete("delete from user where user_id = #{id}")
    void delete(int id);
}
