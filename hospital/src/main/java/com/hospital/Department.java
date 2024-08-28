package com.hospital;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Department {
  @Id
  String NAME;

  String PHONE_NUMBER;

  String CLINICLE_DIRECTOR;

  String HEAD_NURSE;


  public String getNAME() {
    return NAME;
  }

  public void setNAME(String NAME) {
    this.NAME = NAME;
  }

  public String getPHONE_NUMBER() {
    return PHONE_NUMBER;
  }

  public void setPHONE_NUMBER(String PHONE_NUMBER) {
    this.PHONE_NUMBER = PHONE_NUMBER;
  }

  public String getCLINICLE_DIRECTOR() {
    return CLINICLE_DIRECTOR;
  }

  public void setCLINICLE_DIRECTOR(String CLINICLE_DIRECTOR) {
    this.CLINICLE_DIRECTOR = CLINICLE_DIRECTOR;
  }

  public String getHEAD_NURSE() {
    return HEAD_NURSE;
  }

  public void setHEAD_NURSE(String HEAD_NURSE) {
    this.HEAD_NURSE = HEAD_NURSE;
  }
}
