package com.tsaplya.entries;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EntriesByID {
    @RequestMapping(value = "/entries/{id}", method = RequestMethod.GET)
    public String entriesByID(@PathVariable long id) {                      // получение истории списания платежа
        ReceiptOfEntriesByID receiptOfEntriesByID = new ReceiptOfEntriesByID();
        receiptOfEntriesByID.receivingPayment(id);
        return "view";
    }
}
