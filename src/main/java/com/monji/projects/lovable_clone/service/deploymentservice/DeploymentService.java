package com.monji.projects.lovable_clone.service.deploymentservice;

import com.monji.projects.lovable_clone.dto.deploy.DeployResponse;

public interface DeploymentService {
    DeployResponse deploy(Long projectId);
}
