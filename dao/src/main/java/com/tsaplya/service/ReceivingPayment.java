package com.tsaplya.service;


import com.tsaplya.beans.InstructionRegularPayment;

public interface ReceivingPayment {
    InstructionRegularPayment receivingPayment(long id);
}
