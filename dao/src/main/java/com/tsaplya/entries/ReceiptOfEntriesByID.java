package com.tsaplya.entries;

import com.tsaplya.beans.InstructionRegularPayment;
import com.tsaplya.serviceCRUD.ReceivingPayment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReceiptOfEntriesByID implements ReceivingPayment {
    private JdbcTemplate template;

    @Override
    public InstructionRegularPayment receivingPayment(long id) {
        String sql = "SELECT * FROM Entries WHERE id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }
}
