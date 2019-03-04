package com.tsaplya.entries;

import com.tsaplya.beans.InstructionRegularPayment;
import com.tsaplya.service.ReceivingPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReceiptOfEntriesByID implements ReceivingPayment {
    @Autowired
    private JdbcTemplate template;

    @Override
    public InstructionRegularPayment receivingPayment(long id) {
        String sql = "SELECT * FROM Entries WHERE id=?";                       // получения проводки по ID
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }
}
