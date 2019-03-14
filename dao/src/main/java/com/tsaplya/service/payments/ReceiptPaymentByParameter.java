package com.tsaplya.service.payments;

import com.tsaplya.service.model.InstructionRegularPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("service")
public class ReceiptPaymentByParameter {
    private final JdbcTemplate template;

    @Autowired
    public ReceiptPaymentByParameter(final JdbcTemplate template) {
        this.template = template;
    }

    /**
     * Вывод платежа по расчетному счету получателя.
     */
    public InstructionRegularPayment receivingPaymentBybeneficiarysCurrentAccount(long beneficiarysCurrentAccount) {
        String sql =
                "SELECT * FROM RegularPayment WHERE beneficiarysCurrentAccount=" + beneficiarysCurrentAccount + "";
        return template.queryForObject(sql,
                new Object[]{beneficiarysCurrentAccount},
                new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }

    /**
     * Вывод платежа по ID.
     */
    public InstructionRegularPayment receivingPaymentByID(long id) {
        String sql = "SELECT * FROM RegularPayment WHERE id=" + id + "";
        return template.queryForObject(sql,
                new Object[]{id},
                new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }

    /**
     * Вывод платежа по ИНН.
     */
    public InstructionRegularPayment receivingPaymentByINN(long inn) {
        String sql = "SELECT * FROM RegularPayment WHERE inn=" + inn + "";
        return template.queryForObject(sql,
                new Object[]{inn},
                new BeanPropertyRowMapper<>(InstructionRegularPayment.class));
    }

    /**
     * Вывод платежа по OKPO.
     */
    public InstructionRegularPayment receivingPaymentByOKPO(long okpo) {
        String sql = "SELECT * FROM RegularPayment WHERE okpo=" + okpo + "";
        return template.queryForObject(sql,
                new Object[]{okpo},
                new BeanPropertyRowMapper<>(InstructionRegularPayment.class));

    }
}
