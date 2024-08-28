package com.hospital;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class MainController {
  @Autowired
  private DoctorRepository doctorRepository;
 @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private NurseRepository nurseRepository;
  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private PatientRepository patientRepository;

  @PostMapping(path="/account/sign_up") // Map ONLY POST Requests
  public String createNewAccount (@RequestParam String account
      , @RequestParam String password) {
    Account n = new Account();
    n.setPassword(password);
    n.setAccount(account);
    accountRepository.save(n);
    return "index1";
  }

  @PostMapping(path="/account/log_in") // Map ONLY POST Requests
  public String Log_in (@RequestParam String account
      , @RequestParam String password) {
    List<Account> accountlist=new ArrayList<>(accountRepository.findAll());
    for(Account user:accountlist){
      if(user.account.equals(account) && user.password.equals(password)){
          return "first";
      }
    }
    return "index2";
  }
  @PostMapping(path="/doctor/add") // Map ONLY POST Requests
  public String AddDoctor (@RequestParam String DOCTOR_NUMBER, @RequestParam String NAME, @RequestParam String AGE,@RequestParam String SEX,@RequestParam String TITLE,@RequestParam String POSITION,@RequestParam String DEPARTMENT, Model model) {
    Doctor n = new Doctor();
    n.setDOCTOR_NUMBER(DOCTOR_NUMBER);
    n.setNAME(NAME);
    n.setAGE(AGE);
    n.setSEX(SEX);
    n.setTITLE(TITLE);
    n.setPOSITION(POSITION);
    n.setDEPARTMENT(DEPARTMENT);
    doctorRepository.save(n);
    List<Doctor> userlist=new ArrayList<>(doctorRepository.findAll());
    model.addAttribute("list",userlist);
    return "doctor_all";
  }

  @PostMapping(path="/doctor/update") // Map ONLY POST Requests
  public String UpdateDoctor (@RequestParam String DOCTOR_NUMBER, @RequestParam String NAME, @RequestParam String AGE,@RequestParam String SEX,@RequestParam String TITLE,@RequestParam String POSITION,@RequestParam String DEPARTMENT, Model model) {
        Doctor n=doctorRepository.findById(DOCTOR_NUMBER).get();
        n.setDOCTOR_NUMBER(DOCTOR_NUMBER);
        n.setNAME(NAME);
        n.setAGE(AGE);
        n.setSEX(SEX);
        n.setTITLE(TITLE);
        n.setPOSITION(POSITION);
        n.setDEPARTMENT(DEPARTMENT);
        doctorRepository.save(n);
    List<Doctor> userlist=new ArrayList<>(doctorRepository.findAll());
    model.addAttribute("list",userlist);
    return "doctor_all";
  }

  @PostMapping(path="/doctor/first")
  public String getDoctorFirst() {
    return "doctor_first";
  }

  @PostMapping(path="/doctor/all")
  public String getAllDoctor(Model model) {
    List<Doctor> userlist=new ArrayList<>(doctorRepository.findAll());
    model.addAttribute("list",userlist);
    return "doctor_all";
  }

  @PostMapping(path="/doctor/find") 
  public String FindDoctor (@RequestParam(required=false) String DOCTOR_NUMBER, @RequestParam(required=false) String NAME, @RequestParam(required=false) String AGE,@RequestParam(required=false) String SEX,@RequestParam(required=false) String TITLE,@RequestParam(required=false) String POSITION,@RequestParam(required=false) String DEPARTMENT, Model model) {
    List<Doctor> userlist=new ArrayList<>(doctorRepository.findAll());
    List<Doctor> condidate=new ArrayList<>();
    for(Doctor user:userlist){
      if(user.DOCTOR_NUMBER.equals(DOCTOR_NUMBER) || user.NAME.equals(NAME) ||user.AGE.equals(AGE)||user.SEX.equals(SEX)||user.TITLE.equals(TITLE)||user.POSITION.equals(POSITION)||user.DEPARTMENT.equals(DEPARTMENT)){
        condidate.add(user);
      }
    }
    model.addAttribute("condidate",condidate);
    return "doctor_find";
  }

  @PostMapping(path="/doctor/delete") 
  public String DeleteDoctor (@RequestParam String DOCTOR_NUMBER, Model model) {
    doctorRepository.deleteById(DOCTOR_NUMBER);
    List<Doctor> userlist=new ArrayList<>(doctorRepository.findAll());
    model.addAttribute("list",userlist);
    return "doctor_all";
  }
  
  @PostMapping(path="/doctor/return") 
  public String DoctorReturn () {
    return "first";
  }

  @PostMapping(path="/nurse/add") // Map ONLY POST Requests
  public String AddNurse (@RequestParam String NURSE_NUMBER, @RequestParam String NAME, @RequestParam String AGE,@RequestParam String SEX,@RequestParam String TITLE,@RequestParam String POSITION,String DEPARTMENT, Model model) {
    Nurse n = new Nurse();
    n.setNURSE_NUMBER(NURSE_NUMBER);
    n.setNAME(NAME);
    n.setAGE(AGE);
    n.setSEX(SEX);
    n.setTITLE(TITLE);
    n.setPOSITION(POSITION);
    n.setDEPARTMENT(DEPARTMENT);
    nurseRepository.save(n);
    List<Nurse> userlist=new ArrayList<>(nurseRepository.findAll());
    model.addAttribute("list",userlist);
    return "nurse_all";
  }

  @PostMapping(path="/nurse/update") // Map ONLY POST Requests
  public String updateUser (@RequestParam String NURSE_NUMBER, @RequestParam String NAME, @RequestParam String AGE,@RequestParam String SEX,@RequestParam String TITLE,@RequestParam String POSITION,String DEPARTMENT, Model model) {
        Nurse n=nurseRepository.findById(NURSE_NUMBER).get();
        n.setNURSE_NUMBER(NURSE_NUMBER);
        n.setNAME(NAME);
        n.setAGE(AGE);
        n.setSEX(SEX);
        n.setTITLE(TITLE);
        n.setPOSITION(POSITION);
        n.setDEPARTMENT(DEPARTMENT);
        nurseRepository.save(n);
    List<Nurse> userlist=new ArrayList<>(nurseRepository.findAll());
    model.addAttribute("list",userlist);
    return "nurse_all";
  }

  @PostMapping(path="/nurse/first")
  public String getNurseFirst() {
    return "nurse_first";
  }

  @PostMapping(path="/nurse/all")
  public String getAllNurse(Model model) {
    List<Nurse> userlist=new ArrayList<>(nurseRepository.findAll());
    model.addAttribute("list",userlist);
    return "nurse_all";
  }

  @PostMapping(path="/nurse/find") 
  public String Findentity (@RequestParam(required=false) String NURSE_NUMBER, @RequestParam(required=false) String NAME, @RequestParam(required=false) String AGE,@RequestParam(required=false) String SEX,@RequestParam(required=false) String TITLE,@RequestParam(required=false) String POSITION,@RequestParam(required=false) String DEPARTMENT, Model model) {
    List<Nurse> userlist=new ArrayList<>(nurseRepository.findAll());
    List<Nurse> condidate=new ArrayList<>();
    for(Nurse user:userlist){
      if(user.NURSE_NUMBER.equals(NURSE_NUMBER) || user.NAME.equals(NAME) ||user.AGE.equals(AGE)||user.SEX.equals(SEX)||user.TITLE.equals(TITLE)||user.POSITION.equals(POSITION)||user.DEPARTMENT.equals(DEPARTMENT)){
        condidate.add(user);
      }
    }
    model.addAttribute("condidate",condidate);
    return "nurse_find";
  }

  @PostMapping(path="/nurse/delete") 
  public String DeleteEntity (@RequestParam String NURSE_NUMBER, Model model) {
    nurseRepository.deleteById(NURSE_NUMBER);
    List<Nurse> userlist=new ArrayList<>(nurseRepository.findAll());
    model.addAttribute("list",userlist);
    return "nurse_all";
  }
  
  @PostMapping(path="/nurse/return") 
  public String NurseReturn () {
    return "first";
  }

  @PostMapping(path="/department/add") // Map ONLY POST Requests
  public String AddDepartment (@RequestParam String NAME, @RequestParam String PHONE_NUMBER,@RequestParam String CLINICLE_DIRECTOR,@RequestParam String HEAD_NURSE, Model model) {
    Department n = new Department();
    n.setNAME(NAME);
    n.setPHONE_NUMBER(PHONE_NUMBER);
    n.setCLINICLE_DIRECTOR(CLINICLE_DIRECTOR);
    n.setHEAD_NURSE(HEAD_NURSE);
    departmentRepository.save(n);
    List<Department> userlist=new ArrayList<>(departmentRepository.findAll());
    model.addAttribute("list",userlist);
    return "department_all";
  }

  @PostMapping(path="/department/update") // Map ONLY POST Requests
  public String updateDepartment (@RequestParam String NAME, @RequestParam String PHONE_NUMBER,@RequestParam String CLINICLE_DIRECTOR,@RequestParam String HEAD_NURSE, Model model) {
    Department n = new Department();
    n.setNAME(NAME);
    n.setPHONE_NUMBER(PHONE_NUMBER);
    n.setCLINICLE_DIRECTOR(CLINICLE_DIRECTOR);
    n.setHEAD_NURSE(HEAD_NURSE);
    departmentRepository.save(n);
    List<Department> userlist=new ArrayList<>(departmentRepository.findAll());
    model.addAttribute("list",userlist);
    return "department_all";
  }

  @PostMapping(path="/department/first")
  public String getDepartmentFirst() {
    return "department_first";
  }

  @PostMapping(path="/department/all")
  public String getAllDepartment(Model model) {
    List<Department> userlist=new ArrayList<>(departmentRepository.findAll());
    model.addAttribute("list",userlist);
    return "department_all";
  }

  @PostMapping(path="/department/find") 
  public String FindDepartment (@RequestParam(required=false) String NAME, @RequestParam(required=false) String PHONE_NUMBER,@RequestParam(required=false) String CLINICLE_DIRECTOR,@RequestParam(required=false) String HEAD_NURSE, Model model) {
    List<Department> userlist=new ArrayList<>(departmentRepository.findAll());
    List<Department> condidate=new ArrayList<>();
    for(Department user:userlist){
      if(user.NAME.equals(NAME)||user.PHONE_NUMBER.equals(PHONE_NUMBER)||user.CLINICLE_DIRECTOR.equals(CLINICLE_DIRECTOR)||user.HEAD_NURSE.equals(HEAD_NURSE)){
        condidate.add(user);
      }
    }
    model.addAttribute("condidate",condidate);
    return "department_find";
  }

  @PostMapping(path="/department/delete") 
  public String DeleteDepartment (@RequestParam String NAME, Model model) {
    departmentRepository.deleteById(NAME);
    List<Department> userlist=new ArrayList<>(departmentRepository.findAll());
    model.addAttribute("list",userlist);
    return "department_all";
  }

  @PostMapping(path="/department/return") 
  public String DepartmentReturn () {
    return "first";
  }

  @PostMapping(path="/patient/add") // Map ONLY POST Requests
  public String AddPatient (@RequestParam String PATIENT_NUMBER, @RequestParam String NAME, @RequestParam String AGE,@RequestParam String SEX,@RequestParam String PHONE_NUMBER,@RequestParam String ADDRESS,@RequestParam String DIAGNOSIS,@RequestParam String RESPONSIBLE_DOCTOR_NUMBER,@RequestParam String RESPONSIBLE_DOCTOR_NAME,@RequestParam String RESPONSIBLE_NURSE_NUMBER,@RequestParam String RESPONSIBLE_NURSE_NAME,@RequestParam String DEPARTMENT,Model model) {
    Patient n = new Patient();
    n.setNAME(PATIENT_NUMBER);
    n.setPHONE_NUMBER(NAME);
    n.setAGE(AGE);
    n.setSEX(SEX);
    n.setPHONE_NUMBER(PHONE_NUMBER);
    n.setADDRESS(ADDRESS);
    n.setDIAGNOSIS(DIAGNOSIS);
    n.setRESPONSIBLE_DOCTOR_NUMBER(RESPONSIBLE_DOCTOR_NUMBER);
    n.setRESPONSIBLE_DOCTOR_NAME(RESPONSIBLE_DOCTOR_NAME);
    n.setRESPONSIBLE_NURSE_NUMBER(RESPONSIBLE_NURSE_NUMBER);
    n.setRESPONSIBLE_NURSE_NAME(RESPONSIBLE_NURSE_NAME);
    n.setDEPARTMENT(DEPARTMENT);
    patientRepository.save(n);
    List<Patient> userlist=new ArrayList<>(patientRepository.findAll());
    model.addAttribute("list",userlist);
    return "patient_all";
  }

  @PostMapping(path="/patient/update") // Map ONLY POST Requests
  public String updatePatient (@RequestParam String PATIENT_NUMBER, @RequestParam String NAME, @RequestParam String AGE,@RequestParam String SEX,@RequestParam String PHONE_NUMBER,@RequestParam String ADDRESS,@RequestParam String DIAGNOSIS,@RequestParam String RESPONSIBLE_DOCTOR_NUMBER,@RequestParam String RESPONSIBLE_DOCTOR_NAME,@RequestParam String RESPONSIBLE_NURSE_NUMBER,@RequestParam String RESPONSIBLE_NURSE_NAME,@RequestParam String DEPARTMENT,Model model) {
    Patient n = new Patient();
    n.setNAME(PATIENT_NUMBER);
    n.setPHONE_NUMBER(NAME);
    n.setAGE(AGE);
    n.setSEX(SEX);
    n.setPHONE_NUMBER(PHONE_NUMBER);
    n.setADDRESS(ADDRESS);
    n.setDIAGNOSIS(DIAGNOSIS);
    n.setRESPONSIBLE_DOCTOR_NUMBER(RESPONSIBLE_DOCTOR_NUMBER);
    n.setRESPONSIBLE_DOCTOR_NAME(RESPONSIBLE_DOCTOR_NAME);
    n.setRESPONSIBLE_NURSE_NUMBER(RESPONSIBLE_NURSE_NUMBER);
    n.setRESPONSIBLE_NURSE_NAME(RESPONSIBLE_NURSE_NAME);
    n.setDEPARTMENT(DEPARTMENT);
    patientRepository.save(n);
    List<Patient> userlist=new ArrayList<>(patientRepository.findAll());
    model.addAttribute("list",userlist);
    return "patient_all";
  }

  @PostMapping(path="/patient/first")
  public String getPatientFirst() {
    return "patient_first";
  }

  @PostMapping(path="/patient/all")
  public String getAllPatient(Model model) {
    List<Patient> userlist=new ArrayList<>(patientRepository.findAll());
    model.addAttribute("list",userlist);
    return "patient_all";
  }

  @PostMapping(path="/patient/find") 
  public String FindPatient (@RequestParam(required=false) String PATIENT_NUMBER, @RequestParam(required=false) String NAME, @RequestParam(required=false) String AGE,@RequestParam(required=false) String SEX,@RequestParam(required=false) String PHONE_NUMBER,@RequestParam(required=false) String ADDRESS,@RequestParam(required=false) String DIAGNOSIS,@RequestParam(required=false) String RESPONSIBLE_DOCTOR_NUMBER,@RequestParam(required=false) String RESPONSIBLE_DOCTOR_NAME,@RequestParam(required=false) String RESPONSIBLE_NURSE_NUMBER,@RequestParam(required=false) String RESPONSIBLE_NURSE_NAME,@RequestParam(required=false) String DEPARTMENT,Model model) {
    List<Patient> userlist=new ArrayList<>(patientRepository.findAll());
    List<Patient> condidate=new ArrayList<>();
    for(Patient user:userlist){
      if(user.PATIENT_NUMBER.equals(PATIENT_NUMBER)||user.NAME.equals(NAME)||user.AGE.equals(AGE)||user.SEX.equals(SEX)||user.PHONE_NUMBER.equals(PHONE_NUMBER)||user.ADDRESS.equals(ADDRESS)||user.DIAGNOSIS.equals(DIAGNOSIS)||user.RESPONSIBLE_DOCTOR_NUMBER.equals(RESPONSIBLE_DOCTOR_NUMBER)||user.RESPONSIBLE_DOCTOR_NAME.equals(RESPONSIBLE_DOCTOR_NAME)||user.RESPONSIBLE_NURSE_NUMBER.equals(RESPONSIBLE_NURSE_NUMBER)||user.RESPONSIBLE_NURSE_NAME.equals(RESPONSIBLE_NURSE_NAME)||user.DEPARTMENT.equals(DEPARTMENT)){
        Patient entity=patientRepository.findById(NAME).get();
        condidate.add(entity);
      }
    }
    model.addAttribute("condidate",condidate);
    return "patient_find";
  }

  @PostMapping(path="/patient/delete") 
  public String DeletePatient (@RequestParam String NAME, Model model) {
    patientRepository.deleteById(NAME);
    List<Patient> userlist=new ArrayList<>(patientRepository.findAll());
    model.addAttribute("list",userlist);
    return "patient_all";
  }

  @PostMapping(path="/patient/return") 
  public String PatientReturn () {
    return "first";
  }
}