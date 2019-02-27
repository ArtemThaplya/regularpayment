package entries;

import com.regularpayment.beans.InstructionRegularPayment;
import com.regularpayment.beans.TransactionEntries;
import org.springframework.jdbc.core.JdbcTemplate;
import payments.serviceCRUD.CRUD;

public abstract class EntriesCRUD implements CRUD {
    private TransactionEntries regularPayment;
    private JdbcTemplate template;

    @Override
    public int create() {
        String create = "INSERT INTO Entries (idInstructionRegularPayment, dateAndTime, amountOfPayment, status)"
                + "VALUES('" + regularPayment.getIdInstructionRegularPayment() + ",'" + regularPayment.getDateAndTime()
                + ",'" + regularPayment.getAmountOfPayment() + ",'" + regularPayment.getStatus() + "')";
        return template.update(create);
    }

    @Override
    public int update(int id) {
        String update ="UPDATE Entries SET idInstructionRegularPayment='"+regularPayment.getIdInstructionRegularPayment()
                +"',idInstructionRegularPayment='"+regularPayment.getIdInstructionRegularPayment()
                +"',amountOfPayment='"+regularPayment.getAmountOfPayment()
                +"',status='"+regularPayment.getStatus()
                +"' WHERE id="+regularPayment.getId()+"";
        return template.update(update);
    }

    @Override
    public int delete(int id) {
        String delete="DELETE FROM Entries WHERE id="+id+"";
        return template.update(delete);
    }
}
