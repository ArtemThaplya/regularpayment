package com.tsaplya.service.payments;


import com.tsaplya.service.model.InstructionRegularPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Payments {
    private final JdbcTemplate template;

    @Autowired
    public Payments(final JdbcTemplate template) {
        this.template = template;
    }

    public InstructionRegularPayment create(InstructionRegularPayment instructionRegularPayment) {
        String create = "INSERT INTO RegularPayment (fullName, inn, cardNumber, beneficiarysCurrentAccount, mfo, okpo, recipientsName, retirementPeriod, amountOfPayment)"  //запрос в БД, для создания
                + "VALUES('" + instructionRegularPayment.getFullName() + "'," + instructionRegularPayment.getINN() + ",'" + instructionRegularPayment.getCardNumber()
                + ",'" + instructionRegularPayment.getBeneficiarysCurrentAccount() + ",'" + instructionRegularPayment.getMFO() + ",'" + instructionRegularPayment.getOKPO()
                + ",'" + instructionRegularPayment.getRecipientsName() + ",'" + instructionRegularPayment.getRetirementPeriod()
                + ",'" + instructionRegularPayment.getAmountOfPayment() + "')";
        template.update(create);
        return instructionRegularPayment;
    }

    public int update(InstructionRegularPayment instructionRegularPayment) {
        String update = "UPDATE RegularPayment SET fullName='" + instructionRegularPayment.getFullName() + "',inn='" + instructionRegularPayment.getINN() + "',cardNumber='" + instructionRegularPayment.getCardNumber()  //запрос в БД, для изменения
                + "',beneficiarysCurrentAccount='" + instructionRegularPayment.getBeneficiarysCurrentAccount() + "',mfo='" + instructionRegularPayment.getMFO()
                + "',okpo='" + instructionRegularPayment.getOKPO()
                + "',recipientsName='" + instructionRegularPayment.getRecipientsName() + "',retirementPeriod='" + instructionRegularPayment.getRetirementPeriod()
                + "',amountOfPayment='" + instructionRegularPayment.getAmountOfPayment() + "' WHERE id=" + instructionRegularPayment.getId() + "";
        return template.update(update);
    }

    public int deletePayments(int id) {
        String delete = "DELETE FROM RegularPayment WHERE id=" + id + "";     // запрос удаления
        return template.update(delete);
    }
}