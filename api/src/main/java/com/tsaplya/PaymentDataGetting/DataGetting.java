package com.tsaplya.PaymentDataGetting;

import com.tsaplya.service.entries.ReceiptOfEntriesByParameter;
import com.tsaplya.service.payments.ReceiptPaymentByParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataGetting {
    private final ReceiptPaymentByParameter receiptPaymentByParameter;
    private final ReceiptOfEntriesByParameter receiptOfEntriesByParameter;

    @Autowired
    public DataGetting(ReceiptPaymentByParameter receiptPaymentByParameter, ReceiptOfEntriesByParameter receiptOfEntriesByParameter) {
        this.receiptPaymentByParameter = receiptPaymentByParameter;
        this.receiptOfEntriesByParameter = receiptOfEntriesByParameter;
    }

    @RequestMapping(value = "/getPaymentsByPayer/{inn}")
    void getPaymentsByPayer(@PathVariable long inn) {
        receiptPaymentByParameter.receivingPaymentByINN(inn);                   // получение всех платежей по Плательщику
    }

    @RequestMapping(value = "/paymentsByBeneficiarysCurrentAccount/{recipientsName}")
    void paymentsByRecipient(@PathVariable long beneficiarysCurrentAccount) {                // получение всех платежей по получателю
        receiptPaymentByParameter.receivingPaymentByINN(beneficiarysCurrentAccount);
    }

    @RequestMapping(value = "/paymentDebitHistory/{id}", method = RequestMethod.GET)
    String paymentDebitHistory(@PathVariable long id) {                                // получение истории списания платежа
        receiptOfEntriesByParameter.receivingEntriesByID(id);
        return "view";
    }
}
