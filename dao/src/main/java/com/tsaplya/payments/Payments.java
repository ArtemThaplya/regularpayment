package com.tsaplya.payments;


import com.tsaplya.beans.InstructionRegularPayment;
import org.springframework.jdbc.core.JdbcTemplate;

class Payments {
    private JdbcTemplate template;

    int create(InstructionRegularPayment instructionRegularPayment) {
        String create ="INSERT INTO RegularPayment (fullName, inn, cardNumber, beneficiarysCurrentAccount, mfo, okpo, recipientsName, retirementPeriod, amountOfPayment)"  //запрос в БД, для создания
                + "VALUES('"+instructionRegularPayment.getFullName()+"',"+ instructionRegularPayment.getINN()+",'"+instructionRegularPayment.getCardNumber()
                +",'"+instructionRegularPayment.getBeneficiarysCurrentAccount()+",'"+instructionRegularPayment.getMFO()+",'"+instructionRegularPayment.getOKPO()
                +",'"+instructionRegularPayment.getRecipientsName()+",'"+instructionRegularPayment.getRetirementPeriod()
                +",'"+instructionRegularPayment.getAmountOfPayment()+"')";
                return template.update(create);
    }

    int update(InstructionRegularPayment instructionRegularPayment) {
        String update ="UPDATE RegularPayment SET fullName='"+instructionRegularPayment.getFullName()+"',inn='"+instructionRegularPayment.getINN()+"',cardNumber='"+instructionRegularPayment.getCardNumber()  //запрос в БД, для изменения
                +"',beneficiarysCurrentAccount='"+instructionRegularPayment.getBeneficiarysCurrentAccount()+"',mfo='"+instructionRegularPayment.getMFO()
                +"',okpo='"+instructionRegularPayment.getOKPO()
                +"',recipientsName='"+instructionRegularPayment.getRecipientsName()+"',retirementPeriod='"+instructionRegularPayment.getRetirementPeriod()
                +"',amountOfPayment='"+instructionRegularPayment.getAmountOfPayment()+"' WHERE id="+instructionRegularPayment.getId()+"";
        return template.update(update);
    }

    int delete(int id) {
        String delete="DELETE FROM RegularPayment WHERE id="+id+"";     // запрос удаления
        return template.update(delete);
    }

    void check(){

    }
}
