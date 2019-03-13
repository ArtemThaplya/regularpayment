package com.tsaplya.service.payments;


import com.tsaplya.service.model.InstructionRegularPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("service")
public class Payments {
    private final JdbcTemplate template;

    @Autowired
    public Payments(final JdbcTemplate template) {
        this.template = template;
    }

    /**
     * Запрос в БД, для создания платежа.
     */
    public InstructionRegularPayment create(InstructionRegularPayment instructionRegularPayment) {
        String create =
                "INSERT INTO RegularPayment (fullName, inn, cardNumber, beneficiarysCurrentAccount, " +
                        "mfo, okpo, recipientsName, retirementPeriod, amountOfPayment)"
                        + "VALUES('" + instructionRegularPayment.getFullName() + "',"
                        + instructionRegularPayment.getINN() + ",'"
                        + instructionRegularPayment.getCardNumber() + ",'"
                        + instructionRegularPayment.getBeneficiarysCurrentAccount() + ",'"
                        + instructionRegularPayment.getMFO()
                        + ",'" + instructionRegularPayment.getOKPO() + ",'"
                        + instructionRegularPayment.getRecipientsName() + ",'"
                        + instructionRegularPayment.getRetirementPeriod() + ",'"
                        + instructionRegularPayment.getAmountOfPayment() + "')";
        template.update(create);
        return instructionRegularPayment;
    }

    /**
     * Запрос в БД, для изменения.
     */
    public int update(InstructionRegularPayment instructionRegularPayment) {
        String update = "UPDATE RegularPayment SET fullName='" + instructionRegularPayment.getFullName()
                + "',inn='" + instructionRegularPayment.getINN()
                + "',cardNumber='" + instructionRegularPayment.getCardNumber()
                + "',beneficiarysCurrentAccount='" + instructionRegularPayment.getBeneficiarysCurrentAccount()
                + "',mfo='" + instructionRegularPayment.getMFO()
                + "',okpo='" + instructionRegularPayment.getOKPO()
                + "',recipientsName='" + instructionRegularPayment.getRecipientsName()
                + "',retirementPeriod='" + instructionRegularPayment.getRetirementPeriod()
                + "',amountOfPayment='" + instructionRegularPayment.getAmountOfPayment()
                + "' WHERE id=" + instructionRegularPayment.getId() + "";
        return template.update(update);
    }

    /**
     * Запрос удаления платежа.
     */
    public int deletePayments(int id) {
        String delete = "DELETE FROM RegularPayment WHERE id=" + id + "";
        return template.update(delete);
    }
}
