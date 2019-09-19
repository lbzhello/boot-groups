package xyz.lius.javastack.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.lius.javastack.controller.HelloWorldController;

import java.util.HashMap;
import java.util.Map;

// 可以配置拦截指定的类或者包等
// @RestControllerAdvice 使 @ExceptionHandler 注解的方法默认具有 @ResponseBody 注解
@RestControllerAdvice(basePackageClasses = HelloWorldController.class)
public class AppExceptionHandlerAdvice {

    // 配置拦截的错误类型
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> responseEntity(Exception e) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 400);
        map.put("message", e.getMessage());
        return new ResponseEntity<>(map, headers, HttpStatus.BAD_REQUEST);

    }
}
