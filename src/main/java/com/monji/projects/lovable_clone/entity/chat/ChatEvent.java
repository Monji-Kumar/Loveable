package com.monji.projects.lovable_clone.entity.chat;

import com.monji.projects.lovable_clone.enums.ChatEventType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "chat_events")
public class ChatEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_events_seq_gen")
    @SequenceGenerator(name = "chat_events_seq_gen",sequenceName = "chat_events_seq", allocationSize=1, initialValue = 1)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    ChatMessage chatMessage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ChatEventType type;

    @Column(nullable = false)
    Integer sequenceOrder;

    @Column(columnDefinition = "text")
    String content;

    String filePath; // NULL unless FILE_EDIT

    @Column(columnDefinition = "text")
    String metadata;
}
