package com.mzulfucelik.rentacar.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface GenericDTO extends Serializable {
  Long getId();

  void setId(Long id);

  String getName();

  void setName(String name);

  LocalDateTime getCreateDate();

  void setCreateDate(LocalDateTime createDate);

  LocalDateTime getUpdateDate();

  void setUpdateDate(LocalDateTime updateDate);
}
