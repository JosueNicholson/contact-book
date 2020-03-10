package com.contactbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.contactbook.model.Account;
import com.contactbook.repository.AccountRepository;

@Repository
public class ImplementsAccountDetailsService implements UserDetailsService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmail(email);
		if(account == null) throw new UsernameNotFoundException("Account not found");
		return new User(account.getUsername(),account.getPassword(),true,true,true,true, account.getAuthorities());
	}

}
