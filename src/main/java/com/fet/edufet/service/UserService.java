package com.fet.edufet.service;

import com.fet.edufet.dto.UserDto;
import com.fet.edufet.exception.UserNotFound;
import com.fet.edufet.model.User;
import com.fet.edufet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String verify(UserDto dto) {

        Optional<User> userOptional= repository.findByUSERNAME(dto.getUsername());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getPASSWORD().equals(dto.getPassword())) {
                return "User is valid";
            }
            return "User password is invalid";
        }
        throw new UserNotFound("Username "+ dto.getUsername()+ " doesnt exist");
    }

}
