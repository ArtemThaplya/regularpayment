package com.tsaplya.service.entries;

import com.tsaplya.service.model.InstructionRegularPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("service")
public class ReceiptOfEntriesByParameter {
    private JdbcTemplate template;

    @Autowired
    public ReceiptOfEntriesByParameter(JdbcTemplate template) {
        this.template = template;
    }

    public InstructionRegularPayment receivingEntriesByPayment(long id) {
        String sql = "SELECT * FROM Entries WHERE idInstructionRegularPayment=" + id + "";                                          // получения списка проводок по платежу
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }

    public InstructionRegularPayment receivingEntriesByID(long id) {
        String sql = "SELECT * FROM Entries WHERE id=" + id + "";                       // получения проводки по ID
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }
}
