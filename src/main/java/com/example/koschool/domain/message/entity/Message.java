package com.example.koschool.domain.message.entity;

import com.example.koschool.domain.common.BaseEntity;
import com.example.koschool.domain.enums.MessageEnum;
import com.example.koschool.domain.session.entity.Session;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Message")
public class Message extends BaseEntity {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id", unique = true)
    private Long messageId;

    /**
     * 세션 고유 id
     */
    @ManyToOne
    @JoinColumn(referencedColumnName = "session_id", name = "session_id", nullable = false)
    private Session session;

    /**
     * 메시지 내용
     */
    @Column(name = "message_content", nullable = false)
    private String messageContent;

    /**
     * 메시지 타입
     */
    @Column(name = "type", nullable = false)
    private MessageEnum type;
}
