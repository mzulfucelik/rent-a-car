package com.mzulfucelik.rentacar.model;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public abstract class AbstractEntity implements GenericEntity, Cloneable {

    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime createDate = LocalDateTime.now();

    private LocalDateTime updateDate = LocalDateTime.now();

    @Transient
    private Boolean isSimpleEntity;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Boolean getIsSimpleEntity() {
        return isSimpleEntity;
    }

    @Override
    public void setIsSimpleEntity(Boolean isSimpleEntity) {
        this.isSimpleEntity = isSimpleEntity;
    }

    @Override
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    @Override
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

}
