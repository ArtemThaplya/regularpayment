package com.tsaplya.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class InstructionRegularPayment {

    @NotNull(message = "ID cannot be null")
    private int id;

    @NotNull(message = "Full name cannot be null")
    private String fullName;

    @NotNull(message = "INN cannot be null")
    @Size(min = 10, max = 10, message
            = "Must be 10 characters")
    private Long INN;

    @NotNull(message = "Card number cannot be null")
    @Size(min = 16, max = 16, message
            = "Must be 16 characters")
    private Long cardNumber;

    @NotNull(message = "Beneficiary current account cannot be null")
    @Size(min = 20, max = 20, message
            = "Must be 20 characters")
    private Long beneficiarysCurrentAccount;

    @NotNull(message = "MFO cannot be null")
    @Size(min = 6, max = 6, message
            = "Must be 6 characters")
    private int MFO;

    @NotNull(message = "OKPO cannot be null")
    @Size(min = 10, max = 10, message
            = "Must be 10 characters")
    private int OKPO;

    @NotNull(message = "Recipients name cannot be null")
    private String recipientsName;

    @NotNull(message = "Retirement period cannot be null")
    private Date retirementPeriod;

    @Positive
    @NotNull(message = "Amount  of payment cannot be null")
    private BigDecimal amountOfPayment;

    public InstructionRegularPayment() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getINN() {
        return INN;
    }

    public void setINN(Long INN) {
        this.INN = INN;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getBeneficiarysCurrentAccount() {
        return beneficiarysCurrentAccount;
    }

    public void setBeneficiarysCurrentAccount(Long beneficiarysCurrentAccount) {
        this.beneficiarysCurrentAccount = beneficiarysCurrentAccount;
    }

    public int getMFO() {
        return MFO;
    }

    public void setMFO(int MFO) {
        this.MFO = MFO;
    }

    public int getOKPO() {
        return OKPO;
    }

    public void setOKPO(int OKPO) {
        this.OKPO = OKPO;
    }

    public String getRecipientsName() {
        return recipientsName;
    }

    public void setRecipientsName(String recipientsName) {
        this.recipientsName = recipientsName;
    }

    public Date getRetirementPeriod() {
        return retirementPeriod;
    }

    public void setRetirementPeriod(Date retirementPeriod) {
        this.retirementPeriod = retirementPeriod;
    }

    public BigDecimal getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(BigDecimal amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }


}
