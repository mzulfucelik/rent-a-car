package com.mzulfucelik.rentacar.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface GenericEntity extends Serializable {
  Long getId();

  void setId(Long id);

  Boolean getIsSimpleEntity();

  void setIsSimpleEntity(Boolean isSimpleEntity);

  LocalDateTime getCreateDate();

  void setCreateDate(LocalDateTime createDate);

  LocalDateTime getUpdateDate();

  void setUpdateDate(LocalDateTime updateDate);
}
