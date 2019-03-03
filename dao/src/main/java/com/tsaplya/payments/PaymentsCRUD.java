package com.tsaplya.payments;


import com.tsaplya.beans.InstructionRegularPayment;
import com.tsaplya.service.CRUD;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class PaymentsCRUD implements CRUD {
    private JdbcTemplate template;
    @Override
    public int create(InstructionRegularPayment instructionRegularPayment) {
        String create ="INSERT INTO RegularPayment (fullName, inn, cardNumber, beneficiarysCurrentAccount, mfo, okpo, recipientsName, retirementPeriod, amountOfPayment)"
                + "VALUES('"+instructionRegularPayment.getFullName()+"',"+ instructionRegularPayment.getINN()+",'"+instructionRegularPayment.getCardNumber()
                +",'"+instructionRegularPayment.getBeneficiarysCurrentAccount()+",'"+instructionRegularPayment.getMFO()+",'"+instructionRegularPayment.getOKPO()
                +",'"+instructionRegularPayment.getRecipientsName()+",'"+instructionRegularPayment.getRetirementPeriod()
                +",'"+instructionRegularPayment.getAmountOfPayment()+"')";
                return template.update(create);
    }

    @Override
    public int update(InstructionRegularPayment instructionRegularPayment, int id) {
        String update ="UPDATE RegularPayment SET fullName='"+instructionRegularPayment.getFullName()+"',inn='"+instructionRegularPayment.getINN()+"',cardNumber='"+instructionRegularPayment.getCardNumber()
                +"',beneficiarysCurrentAccount='"+instructionRegularPayment.getBeneficiarysCurrentAccount()+"',mfo='"+instructionRegularPayment.getMFO()
                +"',okpo='"+instructionRegularPayment.getOKPO()
                +"',recipientsName='"+instructionRegularPayment.getRecipientsName()+"',retirementPeriod='"+instructionRegularPayment.getRetirementPeriod()
                +"',amountOfPayment='"+instructionRegularPayment.getAmountOfPayment()+"' WHERE id="+instructionRegularPayment.getId()+"";
        return template.update(update);
    }

    @Override
    public int delete(int id) {
        String delete="DELETE FROM RegularPayment WHERE id="+id+"";
        return template.update(delete);
    }
}
