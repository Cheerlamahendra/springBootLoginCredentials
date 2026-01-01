package com.springboot.mahitech99.Repository;

import com.springboot.mahitech99.entityclasses.userSignUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
public interface userSignUpRepository extends JpaRepository<userSignUpEntity,String>
{
    List<userSignUpEntity> findByEmailAndPassword(String email,String password);


    @Query(value="select u.username from userSignUpEntity u where email=:emailId ")
    String findUsernameByEmail(@Param("emailId") String email );


}
