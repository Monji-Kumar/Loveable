package com.monji.projects.lovable_clone.entity.plan;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plan_seq_gen")
    @SequenceGenerator(name = "plan_seq_gen", sequenceName = "plan_seq",  allocationSize = 1, initialValue = 1)
    Long id;

    String name;

    @Column(unique = true)
    String stripePriceId;

    Integer maxProjects;
    Integer maxTokensPerDay;
    Integer maxPreviews; //max number of previews allowed per plan
    Boolean unlimitedAi; //unlimited access to LLM, ignore maxTokensPerDay if true

    Boolean active;
}
