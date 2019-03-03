package com.tsaplya.entries;


import com.tsaplya.beans.TransactionEntries;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class Entries {
    private TransactionEntries transactionEntries;
    private JdbcTemplate template;
    private Date date = new Date();

    public int create(int idInstructionRegularPayment) {
        String create = "INSERT INTO Entries (idInstructionRegularPayment, dateAndTime, amountOfPayment, status)"
                + "VALUES('" + idInstructionRegularPayment + ",'" + date
                + ",'" + transactionEntries.getAmountOfPayment() + ",'" + true + "')";
        return template.update(create);
    }

    public int update(TransactionEntries transactionEntries, int id) {
        String update ="UPDATE Entries SET idInstructionRegularPayment='"+transactionEntries.getIdInstructionRegularPayment()
                +"',idInstructionRegularPayment='"+transactionEntries.getIdInstructionRegularPayment()
                +"',amountOfPayment='"+transactionEntries.getAmountOfPayment()
                +"',status='"+transactionEntries.getStatus()
                +"' WHERE id="+transactionEntries.getId()+"";
        return template.update(update);
    }

    public int delete(int id) {
        String delete="DELETE FROM Entries WHERE id="+id+"";
        return template.update(delete);
    }
}
