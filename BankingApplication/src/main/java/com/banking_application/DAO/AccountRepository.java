package com.banking_application.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking_application.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
