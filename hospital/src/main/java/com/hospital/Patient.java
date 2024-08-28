package com.hospital;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Patient {
  @Id
  String PATIENT_NUMBER;

  String NAME;

  String AGE;

  String SEX;

  String PHONE_NUMBER;

  String ADDRESS;

  String DIAGNOSIS;

  String RESPONSIBLE_DOCTOR_NUMBER;

  String RESPONSIBLE_DOCTOR_NAME;

  String RESPONSIBLE_NURSE_NUMBER;

  String RESPONSIBLE_NURSE_NAME;

  String DEPARTMENT;

  public String getNURSE_NUMBER() {
    return PATIENT_NUMBER;
  }

  public void setPATIENT_NUMBER(String PATIENT_NUMBER) {
    this.PATIENT_NUMBER = PATIENT_NUMBER;
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

  public String getPHONE_NUMBER() {
    return PHONE_NUMBER;
  }

  public void setPHONE_NUMBER(String PHONE_NUMBER) {
    this.PHONE_NUMBER = PHONE_NUMBER;
  }

  public String getADDRESS() {
    return ADDRESS;
  }

  public void setDIAGNOSIS(String DIAGNOSIS) {
    this.DIAGNOSIS = DIAGNOSIS;
  }

  public String getDIAGNOSIS() {
    return DIAGNOSIS;
  }
  public void setADDRESS(String ADDRESS) {
    this.ADDRESS = ADDRESS;
  }

  public String getDEPARTMENT() {
    return DEPARTMENT;
  }
  public void setDEPARTMENT(String DEPARTMENT) {
    this.DEPARTMENT = DEPARTMENT;
  }

  public String getRESPONSIBLE_DOCTOR_NUMBER() {
    return RESPONSIBLE_DOCTOR_NUMBER;
  }

  public void setRESPONSIBLE_DOCTOR_NUMBER(String RESPONSIBLE_DOCTOR_NUMBER) {
    this.RESPONSIBLE_DOCTOR_NUMBER = RESPONSIBLE_DOCTOR_NUMBER;
  }

  public String getRESPONSIBLE_DOCTOR_NAME() {
    return RESPONSIBLE_DOCTOR_NAME;
  }

  public void setRESPONSIBLE_DOCTOR_NAME(String RESPONSIBLE_DOCTOR_NAME) {
    this.RESPONSIBLE_DOCTOR_NAME = RESPONSIBLE_DOCTOR_NAME;
  }

  public String getRESPONSIBLE_NURSE_NUMBER() {
    return RESPONSIBLE_NURSE_NUMBER;
  }

  public void setRESPONSIBLE_NURSE_NUMBER(String RESPONSIBLE_NURSE_NUMBER) {
    this.RESPONSIBLE_NURSE_NUMBER = RESPONSIBLE_NURSE_NUMBER;
  }

  public String getRESPONSIBLE_NURSE_NAME() {
    return RESPONSIBLE_NURSE_NAME;
  }

  public void setRESPONSIBLE_NURSE_NAME(String RESPONSIBLE_NURSE_NAME) {
    this.RESPONSIBLE_NURSE_NAME = RESPONSIBLE_NURSE_NAME;
  }
}