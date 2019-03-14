package com.tsaplya.service.payments;

import com.tsaplya.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentByParameter {
    private final AccessService accessService;

    @Autowired
    public PaymentByParameter(AccessService accessService) {
        this.accessService = accessService;
    }

    /**
     * Вывод платежа по ID
     */
    @RequestMapping("/paymentByID/{id}")
    String paymentByID(int id) {
        accessService.receivingPaymentByID(id);
        return "view";
    }

    /**
     * Вывод платежа по OKPO
     */
    @RequestMapping("/paymentByOKPO/{OKPO}")
    String paymentByOKPO(int OKPO) {
        accessService.receivingPaymentByOKPO(OKPO);
        return "view";
    }

    /**
     * Вывод платежа по ИНН
     */
    @RequestMapping("/paymentByINN/{inn}")
    String paymentByINN(int inn) {
        accessService.receivingPaymentByINN(inn);
        return "view";
    }
}
