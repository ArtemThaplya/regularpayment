package com.tsaplya.payments;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentByID {
    private ReceiptOfPaymentByID receiptOfPaymentByID = new ReceiptOfPaymentByID();

    @RequestMapping("/paymentByID/{id}")
    String paymentByID(int id) {
        receiptOfPaymentByID.receivingPayment(id);     // вывод платежа по ID
        return "view";
    }
}
