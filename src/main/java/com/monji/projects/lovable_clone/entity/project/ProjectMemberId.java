package com.monji.projects.lovable_clone.entity.project;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectMemberId {
    Long projectId;
    Long userId;
}
