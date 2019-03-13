package com.tsaplya.PaymentDataGetting;

import com.tsaplya.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataGetting {
    private final AccessService accessService;

    @Autowired
    public DataGetting(AccessService accessService) {
        this.accessService = accessService;
    }

    /**
     * Получение всех платежей по Плательщику
     */
    @RequestMapping(value = "/getPaymentsByPayer/{inn}")
    void getPaymentsByPayer(@PathVariable long inn) {
        accessService.receivingPaymentByID(inn);
    }

    /**
     * Получение всех платежей по получателю
     */
    @RequestMapping(value = "/paymentsByBeneficiarysCurrentAccount/{recipientsName}")
    void paymentsByRecipient(@PathVariable long beneficiarysCurrentAccount) {
        accessService.receivingPaymentBybeneficiarysCurrentAccount(beneficiarysCurrentAccount);
    }

    /**
     * Получение истории списания платежа
     */
    @RequestMapping(value = "/paymentDebitHistory/{id}", method = RequestMethod.GET)
    String paymentDebitHistory(@PathVariable long id) {
        accessService.receivingEntriesByID(id);
        return "view";
    }
}
