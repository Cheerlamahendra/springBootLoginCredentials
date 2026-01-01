package com.springboot.mahitech99.controller;


import com.springboot.mahitech99.DTOClasses.UserLoginData;
import com.springboot.mahitech99.DTOClasses.UserLoginResponse;
import com.springboot.mahitech99.service.userSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class UserLoginController
{
    @Autowired
    userSignUpService userSignupService;

    @PostMapping(path = "/user/login")
    public UserLoginResponse userLogin(@RequestBody UserLoginData userLoginData)
    {

        UserLoginResponse exist =  userSignupService.userLoginService(userLoginData);
        return exist;
    }

}
