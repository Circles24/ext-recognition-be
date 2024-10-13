package com.circles24.model;

import com.circles24.constant.ExternalRecognitionMediaStatus;
import com.circles24.constant.ExternalRecognitionMediaType;
import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.Timestamp;

@Entity
public class Media {
    @Id
    @GeneratedValue()
    private int id;

    private String refType;

    private int refId;

    private ExternalRecognitionMediaType type;

    private String mediaUrl;

    private Blob mediaContent;

    private ExternalRecognitionMediaStatus status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

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
