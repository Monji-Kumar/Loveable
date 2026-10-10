package com.monji.projects.lovable_clone.repository.project;

import com.monji.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import com.monji.projects.lovable_clone.entity.project.Project;
import com.monji.projects.lovable_clone.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("""
           SELECT p FROM Project p 
           where p. deletedAt IS NULL 
           AND p.ownerId = :userId 
           ORDER BY p.updatedAt DESC
        """)
    List<Project> findAllProjectsByOwner(@Param("userId") Long userId);
}
