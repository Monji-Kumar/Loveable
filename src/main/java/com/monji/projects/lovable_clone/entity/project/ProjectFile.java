package com.monji.projects.lovable_clone.entity.project;


import com.monji.projects.lovable_clone.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "project_file")
public class ProjectFile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_file_seq_gen")
    @SequenceGenerator(name = "project_file_seq_gen", sequenceName = "project_file_seq",  allocationSize = 1, initialValue = 1)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    Project project;

    @Column(nullable = false)
    String path;

    String minioObjectKey;

    Instant createdAt;

    Instant updatedAt;

    @CreatedBy
    User createdBy;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    User updatedBy;

}
