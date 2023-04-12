package com.eg.swa.bankTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.swa.bankTransfer.model.TransferRequest;
import com.eg.swa.bankTransfer.service.TransferService;

@RestController
@RequestMapping("/api")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequest transferRequest) {
        try {
            transferService.transfer(transferRequest.getFromAccountNumber(), transferRequest.getToAccountNumber(), transferRequest.getAmount());
            return ResponseEntity.ok("Transfer successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

