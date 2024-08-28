package com.hospital;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AccountRepository extends CrudRepository<Account, String> {
    List<Account> findAll();
}