package com.tsaplya.payments;

import com.tsaplya.beans.InstructionRegularPayment;
import com.tsaplya.service.ReceivingPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class PaymentByBeneficiarysCurrentAccount implements ReceivingPayment {
    @Autowired
    private JdbcTemplate template;

    @Override
    public InstructionRegularPayment receivingPayment(long beneficiarysCurrentAccount) {
        String sql = "SELECT * FROM RegularPayment WHERE recipientsName=" + beneficiarysCurrentAccount + "";                                                // вывод платежа по ИНН
        return template.queryForObject(sql, new Object[]{beneficiarysCurrentAccount}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }

}
