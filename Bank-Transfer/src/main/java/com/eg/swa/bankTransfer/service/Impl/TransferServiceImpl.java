package com.eg.swa.bankTransfer.service.Impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.swa.bankTransfer.model.Account;
import com.eg.swa.bankTransfer.model.Transaction;
import com.eg.swa.bankTransfer.repository.AccountRepository;
import com.eg.swa.bankTransfer.repository.TransactionRepository;
import com.eg.swa.bankTransfer.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	@Transactional
	public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) throws Exception {
		Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
		Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);
		if (fromAccount.getBalance().compareTo(amount) < 0) {
			throw new Exception("Insufficient balance in account " + fromAccountNumber);
		}
		fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
		toAccount.setBalance(toAccount.getBalance().add(amount));
		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);
		Transaction transaction = new Transaction();
		transaction.setFromAccount(fromAccount);
		transaction.setToAccount(toAccount);
		transaction.setAmount(amount);
		transaction.setTransactionTime(LocalDateTime.now());
		transactionRepository.save(transaction);
	}

}
