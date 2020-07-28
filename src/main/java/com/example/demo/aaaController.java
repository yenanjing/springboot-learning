//package com.example.demo;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class aaaController {
//    @RequestMapping(value = "/")
//    public String index() {
//        return "Hello Spring boot"; // 3
//    }
//}
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(path = "/user")
@ResponseBody
public class aaaController {
    @Autowired
    private final RestService restService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    public aaaController(RestService restService) {
        this.restService = restService;
    }
    @RequestMapping(value = "/")
    public String index() {
        return "Hello Spring boot";
    }
    @RequestMapping(value = "data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity onResRequest(@RequestParam(value = "id") String id){
        Long Id = Long.parseLong(id);
        System.out.println(Id);
        return ResponseEntity.ok(restService.getUserStats(Id));
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public user addTodo(@RequestBody user addedUser) {
        return restService.saveuUer(addedUser);
    }
    @RequestMapping(value = "test")
    public void testRedis() {
        ValueOperations<String,Object> vo= redisTemplate.opsForValue();
        vo.set("data", "data");
        user employee = new user();
        employee.setId((long)1);
        employee.setName("测试");
        employee.setPassword("123");
        vo.set("emp", employee);
    }
}