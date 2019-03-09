package com.tsaplya.payments;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentByINN {
    private ReceiptOfPaymentByINN receiptOfPaymentByINN = new ReceiptOfPaymentByINN();

    @RequestMapping("/paymentByINN/{inn}")
    String paymentByINN(int inn) {
        receiptOfPaymentByINN.receivingPayment(inn);   // вывод платежа по ИНН
        return "view";
    }
}
