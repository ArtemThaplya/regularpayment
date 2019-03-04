package com.tsaplya.payments;

import com.tsaplya.beans.InstructionRegularPayment;
import com.tsaplya.service.ReceivingPayment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReceiptOfPaymentByOKPO implements ReceivingPayment {
    private JdbcTemplate template;

    @Override
    public InstructionRegularPayment receivingPayment(long okpo) {
        String sql = "SELECT * FROM RegularPayment WHERE okpo=?";                                                   // вывод платежа по OKPO
        return template.queryForObject(sql, new Object[]{okpo}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));

    }
}
