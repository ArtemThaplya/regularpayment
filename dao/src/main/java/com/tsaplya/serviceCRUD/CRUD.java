package com.tsaplya.serviceCRUD;

import com.tsaplya.beans.InstructionRegularPayment;
import com.tsaplya.beans.TransactionEntries;


public interface CRUD {


    int create(InstructionRegularPayment instructionRegularPayment);

    int update(InstructionRegularPayment instructionRegularPayment, int id);

    int create(TransactionEntries transactionEntries);

    int create(int idInstructionRegularPayment);

    int update(TransactionEntries transactionEntries, int id);

    int delete(int id);
}
