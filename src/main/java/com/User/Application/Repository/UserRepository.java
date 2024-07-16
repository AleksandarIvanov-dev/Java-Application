package com.User.Application.Repository;

import com.User.Application.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE " +
            "u.firstName LIKE CONCAT('%', :text, '%') " +
            "OR u.lastName LIKE CONCAT('%', :text, '%') " +
            "OR u.email LIKE CONCAT('%', :text, '%')")
    List<User> findByName(@Param("text") String text);

    @Query("SELECT p from User p " +
            "ORDER BY p.lastName,p.dateOfBirth ASC")
    List<User>showAll();
}
