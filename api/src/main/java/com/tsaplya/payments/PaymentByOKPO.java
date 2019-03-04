package com.tsaplya.payments;

import org.springframework.web.bind.annotation.RequestMapping;

public class PaymentByOKPO {
    private ReceiptOfPaymentByOKPO receiptOfPaymentByOKPO;

    @RequestMapping("/paymentByOKPO/{OKPO}")
    String paymentByOKPO(int OKPO) {
        receiptOfPaymentByOKPO.receivingPayment(OKPO);     // вывод платежа по OKPO
        return "view";
    }
}
