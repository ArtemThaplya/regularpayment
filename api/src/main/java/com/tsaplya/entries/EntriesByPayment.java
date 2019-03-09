package com.tsaplya.entries;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntriesByPayment {
    @RequestMapping(value = "/entriesByPayment/{id}", method = RequestMethod.GET)
    public String entriesByPayment(@PathVariable long id) {                         // получения списка проводок по платежу
        ReceiptOfEntriesByPayment receiptOfEntriesByPayment = new ReceiptOfEntriesByPayment();
        receiptOfEntriesByPayment.receivingPayment(id);
        return "view";
    }
}
