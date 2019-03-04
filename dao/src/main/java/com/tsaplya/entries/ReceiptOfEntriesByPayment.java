package com.tsaplya.entries;

import com.tsaplya.beans.InstructionRegularPayment;
import com.tsaplya.service.ReceivingPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReceiptOfEntriesByPayment implements ReceivingPayment {
    @Autowired
    private JdbcTemplate template;

    @Override
    public InstructionRegularPayment receivingPayment(long id) {
        String sql = "SELECT * FROM Entries WHERE idInstructionRegularPayment=?";                                          // получения списка проводок по платежу
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }
}
