package entries;

import com.regularpayment.beans.InstructionRegularPayment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import payments.serviceCRUD.ReceivingPayment;

public class ReceiptOfEntriesByID implements ReceivingPayment {
    private JdbcTemplate template;

    @Override
    public InstructionRegularPayment receivingPayment(long id) {
        String sql = "SELECT * FROM Entries WHERE id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }
}
