package com.contactbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.contactbook.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByEmail(String email);

}
