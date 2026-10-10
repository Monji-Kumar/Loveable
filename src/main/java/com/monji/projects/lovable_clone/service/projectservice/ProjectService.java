package com.monji.projects.lovable_clone.service.projectservice;

import com.monji.projects.lovable_clone.dto.project.ProjectRequest;
import com.monji.projects.lovable_clone.dto.project.ProjectResponse;
import com.monji.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import com.monji.projects.lovable_clone.entity.project.Project;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getAllProjects();

    ProjectResponse getProjectById(Long id);

    Project findProjectById(Long id);

    ProjectResponse getUserProjectById(Long id);

    ProjectResponse createUserProject(ProjectRequest projectRequest);

    ProjectResponse updateUserProject(Long projectId, ProjectRequest projectRequest);

    ProjectResponse deleteUserProject(Long id);

    void softDelete(Long id);
}
