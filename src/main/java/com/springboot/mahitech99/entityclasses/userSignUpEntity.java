package com.springboot.mahitech99.entityclasses;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="user_credential")
@Entity
public class userSignUpEntity
{
    private String username;
    private long mobile;
    @Id
    private String email;
    private String password;

}
