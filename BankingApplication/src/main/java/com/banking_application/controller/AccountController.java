package com.banking_application.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking_application.dto.AccountDto;
import com.banking_application.services.AccountService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.craeteAccount(accountDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") int id){
		AccountDto accountdto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountdto);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> depositAmount(@PathVariable("id") int id, @RequestBody Map<String, Double> request){
		double amount = request.get("amount");
		AccountDto accountdto = accountService.deposit(id, amount);
		return ResponseEntity.ok(accountdto);
	}
	
	@PutMapping("/{id}/withdrow")
	public ResponseEntity<AccountDto> withdrowAmount(@PathVariable("id") int id, @RequestBody Map<String, Double> request){
		double amount = request.get("amount");
		AccountDto accountdto = accountService.withdrow(id, amount);
		return ResponseEntity.ok(accountdto);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accountdto = accountService.getAllAccounts();
		return ResponseEntity.ok(accountdto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAccount(@PathVariable("id") int id){
		this.accountService.deleteAccount(id);
		//return ResponseEntity.ok("Account deleted successfully !!");
	}
	
	
}
