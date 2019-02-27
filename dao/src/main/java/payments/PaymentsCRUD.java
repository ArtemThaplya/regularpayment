package payments;

import com.regularpayment.beans.InstructionRegularPayment;
import org.springframework.jdbc.core.JdbcTemplate;
import payments.serviceCRUD.CRUD;

public abstract class PaymentsCRUD implements CRUD {
    private InstructionRegularPayment regularPayment;
    private JdbcTemplate template;
    @Override
    public int create() {
        String create ="INSERT INTO RegularPayment (fullName, inn, cardNumber, beneficiarysCurrentAccount, mfo, okpo, recipientsName, retirementPeriod, amountOfPayment)"
                + "VALUES('"+regularPayment.getFullName()+"',"+ regularPayment.getINN()+",'"+regularPayment.getCardNumber()
                +",'"+regularPayment.getBeneficiarysCurrentAccount()+",'"+regularPayment.getMFO()+",'"+regularPayment.getOKPO()
                +",'"+regularPayment.getRecipientsName()+",'"+regularPayment.getRetirementPeriod()
                +",'"+regularPayment.getAmountOfPayment()+"')";
                return template.update(create);
    }

    @Override
    public int update(int id) {
        String update ="UPDATE RegularPayment SET fullName='"+regularPayment.getFullName()+"',inn='"+regularPayment.getINN()+"',cardNumber='"+regularPayment.getCardNumber()
                +"',beneficiarysCurrentAccount='"+regularPayment.getBeneficiarysCurrentAccount()+"',mfo='"+regularPayment.getMFO()
                +"',okpo='"+regularPayment.getOKPO()
                +"',recipientsName='"+regularPayment.getRecipientsName()+"',retirementPeriod='"+regularPayment.getRetirementPeriod()
                +"',amountOfPayment='"+regularPayment.getAmountOfPayment()+"' WHERE id="+regularPayment.getId()+"";
        return template.update(update);
    }

    @Override
    public int delete(int id) {
        String delete="DELETE FROM RegularPayment WHERE id="+id+"";
        return template.update(delete);
    }
}
