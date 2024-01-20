package com.pilot.cakepilot.persistence.audit;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class AuditableEntityListener {

    @PrePersist
    public void prePersist(AuditableEntity auditableEntity) {
        LocalDateTime now = LocalDateTime.now();
        auditableEntity.setCreatedDate(now);
        auditableEntity.setModifiedDate(now);
    }

    @PreUpdate
    public void preUpdate(AuditableEntity auditableEntity) {
        auditableEntity.setModifiedDate(LocalDateTime.now());
    }


}
