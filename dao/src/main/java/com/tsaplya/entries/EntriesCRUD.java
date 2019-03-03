package com.tsaplya.entries;


import com.tsaplya.beans.TransactionEntries;
import com.tsaplya.serviceCRUD.CRUD;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public abstract class EntriesCRUD implements CRUD {
    private TransactionEntries transactionEntries;
    private JdbcTemplate template;
    private Date date = new Date();

    @Override
    public int create(int idInstructionRegularPayment) {
        String create = "INSERT INTO Entries (idInstructionRegularPayment, dateAndTime, amountOfPayment, status)"
                + "VALUES('" + idInstructionRegularPayment + ",'" + date
                + ",'" + transactionEntries.getAmountOfPayment() + ",'" + true + "')";
        return template.update(create);
    }

    @Override
    public int update(TransactionEntries transactionEntries, int id) {
        String update ="UPDATE Entries SET idInstructionRegularPayment='"+transactionEntries.getIdInstructionRegularPayment()
                +"',idInstructionRegularPayment='"+transactionEntries.getIdInstructionRegularPayment()
                +"',amountOfPayment='"+transactionEntries.getAmountOfPayment()
                +"',status='"+transactionEntries.getStatus()
                +"' WHERE id="+transactionEntries.getId()+"";
        return template.update(update);
    }

    @Override
    public int delete(int id) {
        String delete="DELETE FROM Entries WHERE id="+id+"";
        return template.update(delete);
    }
}
