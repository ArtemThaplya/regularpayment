package com.tsaplya;

import com.tsaplya.beans.TransactionEntries;
import com.tsaplya.entries.EntriesCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

public class DataAcquisition {
    @Autowired
    private TransactionEntries regularPayment;
    @Autowired
    private EntriesCRUD entriesCRUD;
    @Autowired
    private JdbcTemplate template;

    @RequestMapping("/paymentsByPayer/{fullName}")
    void paymentsByPayer(String fullName){

    }

    @RequestMapping("/paymentsByRecipient/{}")
    void paymentsByRecipient(){

    }

    void paymentDebitHistory(){

    }
}
