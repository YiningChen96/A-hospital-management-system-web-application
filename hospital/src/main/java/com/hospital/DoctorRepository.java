package com.hospital;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DoctorRepository extends CrudRepository<Doctor, String> {
    List<Doctor> findAll();
}