package com.monji.projects.lovable_clone.entity.chat;

import com.monji.projects.lovable_clone.enums.MessageRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_message_seq_gen")
    @SequenceGenerator(name = "chat_message_seq_gen", sequenceName = "chat_message_seq",  allocationSize = 1, initialValue = 1)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false),
            @JoinColumn(name = "user_id", referencedColumnName = "user_id",  nullable = false)
    })
    ChatSession chatSession;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    MessageRole role; //USER, ASSISTANT

    @OneToMany(mappedBy = "chatMessage",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("sequenceOrder ASC")
    List<ChatEvent> chatEvents;

    @Column(columnDefinition = "text")
    String content;

    Integer tokensUsed = 0;

    @CreationTimestamp
    Instant createdAt;
}
