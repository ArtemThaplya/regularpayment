package com.tsaplya.beans;

import java.math.BigDecimal;
import java.util.Date;

public class InstructionRegularPayment {
    private int id;
    private String fullName;
    private Long INN;
    private Long cardNumber;
    private Long beneficiarysCurrentAccount;
    private int MFO;
    private int OKPO;
    private String recipientsName;
    private Date retirementPeriod;
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
