package com.tsaplya.entries;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EntriesByID {
    private ReceiptOfEntriesByID receiptOfEntriesByID;

    @RequestMapping(value = "/entries/{id}", method = RequestMethod.GET)
    public String entriesByID(@PathVariable long id) {                      // получение истории списания платежа
        receiptOfEntriesByID.receivingPayment(id);
        return "view";
    }
}
