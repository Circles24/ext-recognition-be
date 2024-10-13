package com.circles24.model;

import com.circles24.constant.ExternalRecognitionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExternalRecognition {

    @Id
    @GeneratedValue()
    private Integer id;

    private String title;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private ExternalRecognitionStatus status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private int createdBy;

    @PrePersist
    public void prePersist() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
