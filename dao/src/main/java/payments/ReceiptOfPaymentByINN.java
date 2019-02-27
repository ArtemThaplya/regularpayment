package payments;

import com.regularpayment.beans.InstructionRegularPayment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import payments.serviceCRUD.ReceivingPayment;

public class ReceiptOfPaymentByINN implements ReceivingPayment {
    private JdbcTemplate template;

    @Override
    public InstructionRegularPayment receivingPayment(long inn) {
        String sql = "SELECT * FROM RegularPayment WHERE inn=?";
        return template.queryForObject(sql, new Object[]{inn}, new BeanPropertyRowMapper<InstructionRegularPayment>(InstructionRegularPayment.class));

    }
}
