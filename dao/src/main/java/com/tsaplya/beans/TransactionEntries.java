package com.tsaplya.beans;

import com.tsaplya.status.EntriesStatus;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class TransactionEntries {
    @NotNull(message = "ID cannot be null")
    private int id;

    @NotNull(message = "ID cannot be null")
    private int idInstructionRegularPayment;

    @NotNull(message = "ID cannot be null")
    private Date dateAndTime;

    @NotNull(message = "ID cannot be null")
    private BigDecimal amountOfPayment;

    private EntriesStatus status;

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

    public EntriesStatus getStatus() {
        return status;
    }

    public void setStatus(EntriesStatus status) {
        this.status = status;
    }
}
