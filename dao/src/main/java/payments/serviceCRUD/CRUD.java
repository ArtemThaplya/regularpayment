package payments.serviceCRUD;

import com.regularpayment.beans.InstructionRegularPayment;
import com.regularpayment.beans.TransactionEntries;

public interface CRUD {
    public int create();
    public int update(int id);
    public int delete(int id);
}
