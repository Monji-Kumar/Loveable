package com.monji.projects.lovable_clone.entity.preview;

import com.monji.projects.lovable_clone.entity.project.Project;
import com.monji.projects.lovable_clone.enums.PreviewStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "preview")
public class Preview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preview_seq_gen")
    @SequenceGenerator(name = "preview_seq_gen", sequenceName = "preview_seq",  allocationSize = 1, initialValue = 1)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    Project project;

    String namespace;
    String podName;
    String previewUrl;

    PreviewStatus status;


    Instant startedAt;
    Instant terminatedAt;

    @CreationTimestamp
    Instant createdAt;

}
