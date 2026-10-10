package com.monji.projects.lovable_clone.service.projectservice;

import com.monji.projects.lovable_clone.dto.project.ProjectRequest;
import com.monji.projects.lovable_clone.dto.project.ProjectResponse;
import com.monji.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import com.monji.projects.lovable_clone.entity.project.Project;
import com.monji.projects.lovable_clone.entity.user.User;
import com.monji.projects.lovable_clone.mapper.ProjectMapper;
import com.monji.projects.lovable_clone.repository.project.ProjectRepository;
import com.monji.projects.lovable_clone.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserService userService;
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectSummaryResponse> getAllProjects(Long userId) {
//        return projectRepository.findAllProjectsByOwner(userId).stream()
//                .map(projectMapper::toProjectSummaryResponse)
//                .collect(Collectors.toList());

        var projects = projectRepository.findAllProjectsByOwner(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getProjectById(Long id) {
        Project project = findProjectById(id);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public Project findProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow();
    }

    @Override
    public ProjectResponse getUserProjectById(Long userId, Long id) {
        User owner = userService.findById(userId);

        Project project = findProjectById(id);

        if(owner.getId()!= project.getOwner().getId()){
            throw new RuntimeException("Owner and requesting User is not the same");
        }

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createUserProject(Long userId, ProjectRequest projectRequest) {
        User owner = userService.findById(userId);

        Project project = Project.builder()
                .name(projectRequest.name())
                .owner(owner)
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateUserProject(Long userId, Long projectId, ProjectRequest projectRequest) {
        return null;
    }

    @Override
    public ProjectResponse deleteUserProject(Long userId, Long id) {
        return null;
    }
}
