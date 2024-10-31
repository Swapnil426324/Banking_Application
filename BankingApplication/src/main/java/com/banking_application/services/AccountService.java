package com.banking_application.services;

import java.util.List;

import com.banking_application.dto.AccountDto;

public interface AccountService {

	public AccountDto craeteAccount(AccountDto account);
	public AccountDto getAccountById(int id);
	public AccountDto deposit(int id, double amount);
	public AccountDto withdrow(int id, double amount);
	public List<AccountDto> getAllAccounts();
	public void deleteAccount(int id);
}
