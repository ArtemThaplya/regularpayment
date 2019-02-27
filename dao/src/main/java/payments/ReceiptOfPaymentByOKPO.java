package payments;

import com.regularpayment.beans.InstructionRegularPayment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import payments.serviceCRUD.ReceivingPayment;

public class ReceiptOfPaymentByOKPO implements ReceivingPayment {
    private JdbcTemplate template;

    @Override
    public InstructionRegularPayment receivingPayment(long okpo) {
        String sql = "SELECT * FROM RegularPayment WHERE okpo=?";
        return template.queryForObject(sql, new Object[]{okpo}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));

    }
}
