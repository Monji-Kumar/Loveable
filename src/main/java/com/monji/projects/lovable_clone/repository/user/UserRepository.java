package com.monji.projects.lovable_clone.repository.user;

import com.monji.projects.lovable_clone.entity.user.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
    Optional<User> findByUsername(String username);
}
