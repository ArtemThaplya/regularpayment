package payments.serviceCRUD;

import com.regularpayment.beans.InstructionRegularPayment;

public interface ReceivingPayment {
    InstructionRegularPayment receivingPayment(long id);
}
