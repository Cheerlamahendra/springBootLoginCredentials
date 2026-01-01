package com.springboot.mahitech99.service;

import com.springboot.mahitech99.DTOClasses.UserLoginData;
import com.springboot.mahitech99.DTOClasses.UserLoginResponse;
import com.springboot.mahitech99.DTOClasses.UserSignUpData;
import com.springboot.mahitech99.DTOClasses.UserSignUpResponse;
import com.springboot.mahitech99.Repository.userSignUpRepository;
import com.springboot.mahitech99.entityclasses.userSignUpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class userSignUpService
{
    @Autowired
    userSignUpRepository usersignUpRepository1;
    public UserSignUpResponse suerSignUpData(UserSignUpData userSignUpData)
    {

        userSignUpEntity userSignUpEntity1 = new userSignUpEntity();
        userSignUpEntity1.setUsername(userSignUpData.getUsername());
        userSignUpEntity1.setMobile(userSignUpData.getMobile());
        userSignUpEntity1.setEmail(userSignUpData.getEmail());
        userSignUpEntity1.setPassword(userSignUpData.getPassword());


        Optional<userSignUpEntity> check =  usersignUpRepository1.findById(userSignUpData.getEmail());

        System.out.println(check.isPresent());
        UserSignUpResponse userSignUpResponse = new UserSignUpResponse();

        if(check.isPresent())
        {

            userSignUpResponse.setSuccess("false");
            userSignUpResponse.setMessage("User Email Already Exists please try again");

            return userSignUpResponse;
        }
        else {
            usersignUpRepository1.save(userSignUpEntity1);

            userSignUpResponse.setSuccess("true");
            userSignUpResponse.setMessage("User signUp Successful");
            return userSignUpResponse;
        }


    }

    public UserLoginResponse userLoginService(UserLoginData userLoginData)
    {
        List<userSignUpEntity> eixts= usersignUpRepository1.findByEmailAndPassword(userLoginData.getEmail(),userLoginData.getPassword());
        UserLoginResponse response = new UserLoginResponse();
        if(!eixts.isEmpty())
        {

            response.setSuccess("true");
            response.setMessage("User Login Successful");
            String username = usersignUpRepository1.findUsernameByEmail(userLoginData.getEmail());
            response.setUsername(username);
            return response;
        }
        else {
            response.setSuccess("false");
            response.setMessage("Invalid Credentials");
            return response;
        }
    }

}
