package com.tsaplya.entries;

import com.tsaplya.beans.InstructionRegularPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StartWriteOff {
    @Autowired
    private JdbcTemplate template;

    public List<InstructionRegularPayment> allPayments() {
        return template.query("SELECT * FROM RegularPayment", (rs, row) -> {
            InstructionRegularPayment e = new InstructionRegularPayment();
            e.setId(rs.getInt(1));
            e.setFullName(rs.getString(2));
            e.setINN(rs.getLong(3));
            e.setCardNumber(rs.getLong(4));
            e.setBeneficiarysCurrentAccount(rs.getLong(5));
            e.setMFO(rs.getInt(6));
            e.setOKPO(rs.getInt(7));
            e.setRecipientsName(rs.getString(8));
            e.setRetirementPeriod(rs.getDate(9));
            e.setAmountOfPayment(rs.getBigDecimal(10));
            return e;
        });
    }
}
