package com.tsaplya.entries;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class GetEntriesByPayment {
    private ReceiptOfEntriesByPayment receiptOfEntriesByPayment;

    @RequestMapping(value = "/entriesByPayment/{id}", method = RequestMethod.GET)
    public String entriesByPayment(@PathVariable long id) {
        receiptOfEntriesByPayment.receivingPayment(id);
        return "view";
    }
}
