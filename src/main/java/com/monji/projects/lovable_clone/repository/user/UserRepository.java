package com.monji.projects.lovable_clone.repository.user;

import com.monji.projects.lovable_clone.entity.user.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UserRepository extends JpaRepositoryImplementation<User,Long> {
}
