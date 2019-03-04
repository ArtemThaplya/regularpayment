package com.tsaplya.entries;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EntriesByPayment {
    private ReceiptOfEntriesByPayment receiptOfEntriesByPayment;

    @RequestMapping(value = "/entriesByPayment/{id}", method = RequestMethod.GET)
    public String entriesByPayment(@PathVariable long id) {                         // получения списка проводок по платежу
        receiptOfEntriesByPayment.receivingPayment(id);
        return "view";
    }
}
