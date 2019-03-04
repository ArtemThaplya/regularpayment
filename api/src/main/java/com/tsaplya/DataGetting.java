package com.tsaplya;

import com.tsaplya.entries.EntriesByID;
import com.tsaplya.payments.PaymentByBeneficiarysCurrentAccount;
import com.tsaplya.payments.ReceiptOfPaymentByINN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class DataGetting {
    private ReceiptOfPaymentByINN receiptOfPaymentByINN;
    private PaymentByBeneficiarysCurrentAccount getPaymentBynecipientsName;
    private EntriesByID getEntriesByID;
    @Autowired
    private JdbcTemplate template;

    @RequestMapping(value = "/getPaymentsByPayer/{inn}")
    void getPaymentsByPayer(@PathVariable long inn) {
        receiptOfPaymentByINN.receivingPayment(inn);                   // получение всех платежей по Плательщику
    }

    @RequestMapping(value = "/paymentsByBeneficiarysCurrentAccount/{recipientsName}")
    void paymentsByRecipient(@PathVariable long beneficiarysCurrentAccount) {                // получение всех платежей по получателю
        getPaymentBynecipientsName.receivingPayment(beneficiarysCurrentAccount);
    }

    @RequestMapping(value = "/paymentDebitHistory/{id}", method = RequestMethod.GET)
    String paymentDebitHistory(@PathVariable long id) {                                // получение истории списания платежа
        getEntriesByID.entriesByID(id);
        return "view";
    }
}
