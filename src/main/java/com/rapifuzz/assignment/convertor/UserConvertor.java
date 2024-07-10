package com.rapifuzz.assignment.convertor;

import com.rapifuzz.assignment.dto.UserRequestDto;
import com.rapifuzz.assignment.dto.UserResponseDto;
import com.rapifuzz.assignment.entity.User;

public class UserConvertor {
    public User dtoToUserEntity(UserRequestDto userRequest){
        User user = new User();
        user.setCity(userRequest.getCity());
        user.setCountry(userRequest.getCountry());
        user.setEmailAddress(userRequest.getEmailAddress());
        user.setCountryCode(userRequest.getCountryCode());
        user.setFax(userRequest.getFax());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setMobileNo(userRequest.getMobileNo());
        user.setPhone(userRequest.getPhone());
        user.setPassword(userRequest.getPassword());
        user.setState(userRequest.getState());
        user.setPincode(userRequest.getPincode());
        return  user;
    }
}
