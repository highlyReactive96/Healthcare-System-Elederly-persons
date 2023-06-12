package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Activity;
import com.example.demo.pojos.User;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByUser(User user);
}


//public interface ActivityRepository extends JpaRepository<Activity, Long> {
//
//	List<Activity> findByUserId(Long userId);
//    //we can  Add custom query methods if needed
//}
