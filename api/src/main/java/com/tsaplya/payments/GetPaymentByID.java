package com.tsaplya.payments;

import org.springframework.web.bind.annotation.RequestMapping;

public class GetPaymentByID {
    private ReceiptOfPaymentByID receiptOfPaymentByID;

    @RequestMapping("/paymentByID/{id}")
    String paymentByID(int id) {
        receiptOfPaymentByID.receivingPayment(id);     // вывод платежа по ID
        return "view";
    }
}
