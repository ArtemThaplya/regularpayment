package com.tsaplya.payments;

import com.tsaplya.beans.InstructionRegularPayment;
import com.tsaplya.service.ReceivingPayment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReceiptOfPaymentByINN implements ReceivingPayment {
    private JdbcTemplate template;

    @Override
    public InstructionRegularPayment receivingPayment(long inn) {
        String sql = "SELECT * FROM RegularPayment WHERE inn=?";
        return template.queryForObject(sql, new Object[]{inn}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }
}
