package com.tsaplya.payments;

import com.tsaplya.beans.InstructionRegularPayment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PaymentsTest {

    @Test
    public void create() {
        Payments payments = new Payments();
        InstructionRegularPayment regularPayment =
                new InstructionRegularPayment(1, "Artem Tsaplya", 1234567890, 1234567887654321, 12345678900987654321
                        , 123456, 1234567890, "Private", "04-03-2019", 30000);

        InstructionRegularPayment instructionRegularPayment = payments.create(regularPayment);
        assertNotNull(instructionRegularPayment);
        assertEquals(1, instructionRegularPayment.getId());
        assertEquals("Artem Tsaplya", instructionRegularPayment.getFullName());
        assertEquals(1234567890, instructionRegularPayment.getINN());
        assertEquals(1234567887654321, instructionRegularPayment.getCardNumber());
        assertEquals(12345678900987654321, instructionRegularPayment.getBeneficiarysCurrentAccount());
        assertEquals(123456, instructionRegularPayment.getMFO());
        assertEquals(1234567890, instructionRegularPayment.getOKPO());
        assertEquals("Private", instructionRegularPayment.getRecipientsName());
        assertEquals("04-03-2019", instructionRegularPayment.getRetirementPeriod());
        assertEquals(30000, instructionRegularPayment.getAmountOfPayment());
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}