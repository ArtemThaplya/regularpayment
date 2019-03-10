package com.tsaplya.service;

import com.tsaplya.service.entries.Entries;
import com.tsaplya.service.entries.ReceiptOfEntriesByParameter;
import com.tsaplya.service.entries.StartWriteOff;
import com.tsaplya.service.model.InstructionRegularPayment;
import com.tsaplya.service.model.TransactionEntries;
import com.tsaplya.service.payments.Payments;
import com.tsaplya.service.payments.ReceiptPaymentByParameter;
import com.tsaplya.service.payments.VerificationWriteOff;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableConfigurationProperties({Entries.class, ReceiptOfEntriesByParameter.class, StartWriteOff.class, Payments.class,
        ReceiptPaymentByParameter.class, VerificationWriteOff.class})
public class AccessService {
    private final Entries entries;
    private final ReceiptOfEntriesByParameter receiptOfEntriesByParameter;
    private final StartWriteOff startWriteOff;
    private final Payments payments;
    private final ReceiptPaymentByParameter receiptPaymentByParameter;
    private final VerificationWriteOff verificationWriteOff;

    public AccessService(final Entries entries,
                         final ReceiptOfEntriesByParameter receiptOfEntriesByParameter,
                         final StartWriteOff startWriteOff,
                         final Payments payments,
                         final ReceiptPaymentByParameter receiptPaymentByParameter,
                         final VerificationWriteOff verificationWriteOff) {
        this.entries = entries;
        this.receiptOfEntriesByParameter = receiptOfEntriesByParameter;
        this.startWriteOff = startWriteOff;
        this.payments = payments;
        this.receiptPaymentByParameter = receiptPaymentByParameter;
        this.verificationWriteOff = verificationWriteOff;
    }

    public int create(int idInstructionRegularPayment) {
        return entries.create(idInstructionRegularPayment);
    }

    public int update(TransactionEntries transactionEntries, int id) {
        return entries.update(transactionEntries, id);
    }

    public int delete(int id) {
        return entries.delete(id);
    }

    public InstructionRegularPayment receivingEntriesByPayment(long id) {
        return receiptOfEntriesByParameter.receivingEntriesByPayment(id);
    }

    public InstructionRegularPayment receivingEntriesByID(long id) {
        return receiptOfEntriesByParameter.receivingEntriesByID(id);
    }

    public List<InstructionRegularPayment> allPayments() {
        return startWriteOff.allPayments();
    }

    public void verificationOfNeedForWriteOffPayment() {
        startWriteOff.verificationOfNeedForWriteOffPayment();
    }

    public InstructionRegularPayment create(InstructionRegularPayment instructionRegularPayment) {
        return payments.create(instructionRegularPayment);
    }

    public int update(InstructionRegularPayment instructionRegularPayment) {
        return payments.update(instructionRegularPayment);
    }

    public int deletePayments(int id) {
        return payments.deletePayments(id);
    }

    public InstructionRegularPayment receivingPaymentBybeneficiarysCurrentAccount(long beneficiarysCurrentAccount) {
        return receiptPaymentByParameter.receivingPaymentBybeneficiarysCurrentAccount(beneficiarysCurrentAccount);
    }

    public InstructionRegularPayment receivingPaymentByID(long id) {
        return receiptPaymentByParameter.receivingPaymentByID(id);
    }

    public InstructionRegularPayment receivingPaymentByINN(long inn) {
        return receiptPaymentByParameter.receivingPaymentByINN(inn);
    }

    public InstructionRegularPayment receivingPaymentByOKPO(long okpo) {
        return receiptPaymentByParameter.receivingPaymentByOKPO(okpo);
    }

    public long verificationOfNeedForWriteOffOrNot(int idInstructionRegularPayment) {
        return verificationWriteOff.verificationOfNeedForWriteOffOrNot(idInstructionRegularPayment);
    }
}
