package com.tsaplya.service.payments;

import com.tsaplya.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    String paymentByID(@PathVariable("id") String id) {
        accessService.receivingPaymentByID(Long.parseLong(id));
        return "view";
    }

    /**
     * Вывод платежа по OKPO
     */
    @RequestMapping("/paymentByOKPO/{OKPO}")
    String paymentByOKPO(@PathVariable("OKPO") String OKPO) {
        accessService.receivingPaymentByOKPO(OKPO);
        return "view";
    }

    /**
     * Вывод платежа по ИНН
     */
    @RequestMapping("/paymentByINN/{inn}")
    String paymentByINN(@PathVariable("inn") String inn) {
        accessService.receivingPaymentByINN(inn);
        return "view";
    }
}
