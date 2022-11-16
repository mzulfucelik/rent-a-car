package com.mzulfucelik.rentacar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class AbstractDTO implements GenericDTO {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
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
