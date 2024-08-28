package com.hospital;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Doctor {
  @Id
  String DOCTOR_NUMBER;

  String NAME;

  String AGE;

  String SEX;

  String TITLE;

  String POSITION;

  String DEPARTMENT;

  public String getDOCTOR_NUMBER() {
    return DOCTOR_NUMBER;
  }

  public void setDOCTOR_NUMBER(String DOCTOR_NUMBER) {
    this.DOCTOR_NUMBER = DOCTOR_NUMBER;
  }

  public String getNAME() {
    return NAME;
  }

  public void setNAME(String NAME) {
    this.NAME = NAME;
  }

  public String getAGE() {
    return AGE;
  }

  public void setAGE(String AGE) {
    this.AGE = AGE;
  }

  public String getSEX() {
    return SEX;
  }

  public void setSEX(String SEX) {
    this.SEX = SEX;
  }

  public String getTITLE() {
    return TITLE;
  }

  public void setTITLE(String TITLE) {
    this.TITLE = TITLE;
  }

  public String getPOSITION() {
    return POSITION;
  }

  public void setPOSITION(String POSITION) {
    this.POSITION = POSITION;
  }

  public String getDEPARTMENT() {
    return DEPARTMENT;
  }

  public void setDEPARTMENT(String DEPARTMENT) {
    this.DEPARTMENT = DEPARTMENT;
  }

}