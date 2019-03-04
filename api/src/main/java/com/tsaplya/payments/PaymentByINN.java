package com.tsaplya.payments;

import org.springframework.web.bind.annotation.RequestMapping;

public class PaymentByINN {
    private ReceiptOfPaymentByINN receiptOfPaymentByINN;

    @RequestMapping("/paymentByINN/{inn}")
    String paymentByINN(int inn) {
        receiptOfPaymentByINN.receivingPayment(inn);   // вывод платежа по ИНН
        return "view";
    }
}
