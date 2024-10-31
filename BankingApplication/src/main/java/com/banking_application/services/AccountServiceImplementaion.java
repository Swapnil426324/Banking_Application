package com.banking_application.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banking_application.DAO.AccountRepository;
import com.banking_application.dto.AccountDto;
import com.banking_application.maper.AccountMaper;
import com.banking_application.model.Account;

@Service
public class AccountServiceImplementaion implements AccountService{

	// inject dependancy using constructor method
	public AccountServiceImplementaion(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	private AccountRepository accountRepository;
	
	@Override
	public AccountDto craeteAccount(AccountDto accountdto) {
	
		Account account = AccountMaper.mapToAccount(accountdto);
		Account saveAccount = accountRepository.save(account);
		return AccountMaper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto getAccountById(int id) {
		Account account = accountRepository.findById(id).orElseThrow((()-> new RuntimeException("Account does not Exist")));
		return AccountMaper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(int id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow((()-> new RuntimeException("Account does not Exist")));
		double totalBalance = account.getBalance() + amount;
		account.setBalance(totalBalance);
		Account saveAccount = accountRepository.save(account);
		return AccountMaper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto withdrow(int id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow((()-> new RuntimeException("Account does not Exist")));
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		double totalBalance = account.getBalance() - amount;
		account.setBalance(totalBalance);
		Account saveAccount = accountRepository.save(account);
		return AccountMaper.mapToAccountDto(saveAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		return accountRepository.findAll().stream().map((account)->AccountMaper.mapToAccountDto(account)).collect(Collectors.toList());
		
	}

	@Override
	public void deleteAccount(int id) {
		Account account = this.accountRepository.getOne(id);
		this.accountRepository.delete(account);
	}

	

	
}
