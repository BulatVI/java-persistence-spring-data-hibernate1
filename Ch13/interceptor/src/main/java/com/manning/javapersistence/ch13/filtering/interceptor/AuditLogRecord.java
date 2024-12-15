 package com.manning.javapersistence.ch13.filtering.interceptor;

import com.manning.javapersistence.ch13.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class AuditLogRecord {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @NotNull
    private String message;

    @NotNull
    private Long entityId;

    @NotNull
    private Class<? extends Auditable> entityClass;

    @NotNull
    private Long userId;

    @NotNull
    private LocalDateTime createdOn = LocalDateTime.now();

    public AuditLogRecord() {
    }

    public AuditLogRecord(String message,
                          Auditable entityInstance,
                          Long userId) {
        this.message = message;
        this.entityId = entityInstance.getId();
        this.entityClass = entityInstance.getClass();
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Long getEntityId() {
        return entityId;
    }

    public Class<? extends Auditable> getEntityClass() {
        return entityClass;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}
