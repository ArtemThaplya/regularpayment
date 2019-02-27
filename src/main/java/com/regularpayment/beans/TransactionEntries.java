package com.regularpayment.beans;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionEntries {
    private int id;
    private int idInstructionRegularPayment;
    private Date dateAndTime;
    private BigDecimal amountOfPayment;
    private Boolean status;

    public TransactionEntries() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInstructionRegularPayment() {
        return idInstructionRegularPayment;
    }

    public void setIdInstructionRegularPayment(int idInstructionRegularPayment) {
        this.idInstructionRegularPayment = idInstructionRegularPayment;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public BigDecimal getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(BigDecimal amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
