package com.tsaplya.service.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentByParameter {
    private final PaymentByParameter paymentByParameter;

    @Autowired
    public PaymentByParameter(PaymentByParameter paymentByParameter) {
        this.paymentByParameter = paymentByParameter;
    }

    @RequestMapping("/paymentByID/{id}")
    String paymentByID(int id) {
        paymentByParameter.paymentByID(id);     // вывод платежа по ID
        return "view";
    }

    @RequestMapping("/paymentByOKPO/{OKPO}")
    String paymentByOKPO(int OKPO) {
        paymentByParameter.paymentByOKPO(OKPO);     // вывод платежа по OKPO
        return "view";
    }

    @RequestMapping("/paymentByINN/{inn}")
    String paymentByINN(int inn) {
        paymentByParameter.paymentByINN(inn);   // вывод платежа по ИНН
        return "view";
    }
}
