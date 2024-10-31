package com.banking_application.maper;

import com.banking_application.dto.AccountDto;
import com.banking_application.model.Account;

public class AccountMaper {

	public static Account mapToAccount(AccountDto accountdto) {
		Account account = new Account(
				accountdto.getId(),
				accountdto.getAccountHolderName(),
				accountdto.getBalance()
				);
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountdto = new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				);
		return accountdto;
	}
	
	
	
}
