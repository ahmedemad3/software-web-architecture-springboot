package com.eg.swa.bankTransfer.service;

import java.math.BigDecimal;

public interface TransferService {
	public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) throws Exception;

}
