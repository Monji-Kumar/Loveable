package com.monji.projects.lovable_clone.service.projecttemplateservice;

import com.monji.projects.lovable_clone.entity.project.Project;
import com.monji.projects.lovable_clone.entity.project.ProjectFile;
import com.monji.projects.lovable_clone.error.ResourceNotFoundException;
import com.monji.projects.lovable_clone.repository.project.ProjectFileRepository;
import com.monji.projects.lovable_clone.repository.project.ProjectRepository;
import io.minio.*;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProjectTemplateServiceImpl implements ProjectTemplateService {

    private final MinioClient minioClient;
    private final ProjectFileRepository  projectFileRepository;
    private final ProjectRepository projectRepository;

    private static final String TEMPLATE_BUCKET = "starter-projects";
    private static final String TARGET_BUCKET = "projects";
    private static final String TEMPLATE_NAME = "starter-projects";

    @Override
    public void initializeProjectFromTemplate(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));

        try {
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder()
                            .bucket(TEMPLATE_BUCKET)
                            .prefix(TEMPLATE_NAME + "/")
                            .recursive(true).build()
            );

            List<ProjectFile> filesToSave = new ArrayList<>();

            for(Result<Item> result: results) {
                Item item = result.get();
                String sourceKey = item.objectName();

                String cleanPath = sourceKey.replaceFirst(TEMPLATE_NAME + "/", "");
                String destKey = projectId + "/" +  cleanPath;

                minioClient.copyObject(
                        CopyObjectArgs.builder()
                                .bucket(TARGET_BUCKET)
                                .object(destKey)
                                .source(CopySource.builder()
                                        .bucket(TEMPLATE_BUCKET)
                                        .object(sourceKey)
                                        .build()
                                ).build()
                );

                ProjectFile pf = ProjectFile.builder().project(project)
                        .path(cleanPath)
                        .minioObjectKey(destKey)
                        .createdAt(Instant.now())
                        .updatedAt(Instant.now())
                        .build();

                filesToSave.add(pf);
            }

            projectFileRepository.saveAll(filesToSave);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to initialize project from template", ex);
        }

    }
}
