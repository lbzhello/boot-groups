package xyz.lius.mvc.mapper;

import org.apache.ibatis.annotations.*;
import xyz.lius.mvc.entity.HelloWorld;

import java.util.List;

@Mapper
public interface HelloWorldMapper {
    @Select("select * from hello_world")
    @Results(id = "helloWorld", value = {
            @Result(column = "hello_world_id", property = "helloWorldId")
    })
    List<HelloWorld> findAll();

    @Select("select * from hello_world where hello_world_id = #{id}")
    @ResultMap("helloWorld")
    HelloWorld findOne(String id);

    @Insert("insert into hello_world (hello_world_id, message) values (#{helloWorldId}, #{message})")
    void insert(HelloWorld helloWorld);

    @Update("update hello_world set hello_world_id = #{helloWorldId}, message = #{message} where hello_world_id = #{helloWorldId}")
    void update(HelloWorld helloWorld);

    @Delete("delete from hello_world where hello_world_id = #{id}")
    void delete(String id);
}
