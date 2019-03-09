package com.tsaplya.payments;

import com.tsaplya.beans.InstructionRegularPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class ReceiptPaymentByParameter {
    private final JdbcTemplate template;

    @Autowired
    public ReceiptPaymentByParameter(final JdbcTemplate template) {
        this.template = template;
    }

    public InstructionRegularPayment receivingPaymentBybeneficiarysCurrentAccount(long beneficiarysCurrentAccount) {
        String sql = "SELECT * FROM RegularPayment WHERE beneficiarysCurrentAccount=" + beneficiarysCurrentAccount + "";                                                // вывод платежа по РС
        return template.queryForObject(sql, new Object[]{beneficiarysCurrentAccount}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }


    public InstructionRegularPayment receivingPaymentByID(long id) {
        String sql = "SELECT * FROM RegularPayment WHERE id=" + id + "";                    // вывод платежа по ID
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }

    public InstructionRegularPayment receivingPaymentByINN(long inn) {
        String sql = "SELECT * FROM RegularPayment WHERE inn=" + inn + "";                                                // вывод платежа по ИНН
        return template.queryForObject(sql, new Object[]{inn}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }

    public InstructionRegularPayment receivingPaymentByOKPO(long okpo) {
        String sql = "SELECT * FROM RegularPayment WHERE okpo=" + okpo + "";                                                   // вывод платежа по OKPO
        return template.queryForObject(sql, new Object[]{okpo}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));

    }
}
