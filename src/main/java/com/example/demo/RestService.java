package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class RestService {
    private UserRepository userRepository;

    @Autowired
    public RestService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserStats(Long id){
        user User= userRepository.findById(id);
        String result="{ID : "+User.getId().toString()+",name : "+User.getName()+",Password :"+ User.getPassword()+" }";

        return result;
    }

    public user saveuUer(user User) {
        return userRepository.save(User);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
        return;
    }

    public List<user> findAll(String userId) {
        // 查询所有的实体
        List<user> userList = userRepository.findAll();
        return userList;
    }

    public user findById(String id) {
        // 根据id查询对应实体
        Optional<user> customer = userRepository.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        }
        return null;
    }

}