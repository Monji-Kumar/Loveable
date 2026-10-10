package com.monji.projects.lovable_clone.entity.usagelogs;

import com.monji.projects.lovable_clone.entity.project.Project;
import com.monji.projects.lovable_clone.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "usage_log")
public class UsageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usage_log_seq_gen")
    @SequenceGenerator(name = "usage_log_seq_gen", sequenceName = "usage_log_seq",  allocationSize = 1, initialValue = 1)
    Long id;

    @Column(nullable = false, name = "user_id")
    Long userId;

    @Column(nullable = false)
    LocalDate date;

    Integer tokensUsed;
}
