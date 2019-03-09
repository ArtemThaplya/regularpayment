package com.tsaplya.entries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntriesByParameter {
    private final ReceiptOfEntriesByParameter receiptOfEntriesByParameter;

    @Autowired
    public EntriesByParameter(final ReceiptOfEntriesByParameter receiptOfEntriesByParameter) {
        this.receiptOfEntriesByParameter = receiptOfEntriesByParameter;
    }

    @RequestMapping(value = "/entriesByPayment/{id}", method = RequestMethod.GET)
    public String entriesByPayment(@PathVariable long id) {                         // получения списка проводок по платежу
        receiptOfEntriesByParameter.receivingEntriesByPayment(id);
        return "view";
    }

    @RequestMapping(value = "/entries/{id}", method = RequestMethod.GET)
    public String entriesByID(@PathVariable long id) {                      // получение истории списания платежа
        receiptOfEntriesByParameter.receivingEntriesByID(id);
        return "view";
    }


}
