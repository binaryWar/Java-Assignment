package com.rapifuzz.assignment.services;

import com.rapifuzz.assignment.convertor.UserConvertor;
import com.rapifuzz.assignment.dto.UserRequestDto;
import com.rapifuzz.assignment.entity.User;
import com.rapifuzz.assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User register(UserRequestDto userRequest) {
        // convert userRequest to user Entity
        User user = new UserConvertor().dtoToUserEntity(userRequest);
        User returnObject  = this.userRepository.save(user);
        return returnObject;
    }
}
