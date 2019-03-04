package com.tsaplya.entries;

import com.tsaplya.beans.InstructionRegularPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class StartWriteOff {
    private Entries entries;
    @Autowired
    private JdbcTemplate template;

    public List<InstructionRegularPayment> allPayments() {
        return template.query("SELECT * FROM RegularPayment", (rs, row) -> {         // выбор всех платежей
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

    public void verificationOfNeedForWriteOffPayment() {
        long currentTimeMilliSeconds = System.currentTimeMillis();                                                          // текущеее время
        List<InstructionRegularPayment> listRegularPayment = allPayments();                                                 // выбор всех платежей, сохранение в списке
        for (InstructionRegularPayment list : listRegularPayment) {
            int idInstructionRegularPayment = list.getId();
            String sqlRetirementPeriod = "SELECT retirementPeriod FROM RegularPayment WHERE  id=" + idInstructionRegularPayment + "";         // дата списания
            String sqlLastEntries = "SELECT dateAndTime FROM Entries WHERE idInstructionRegularPayment=" + idInstructionRegularPayment + "";  // последнее списание
            String timePeriod = template.queryForObject(sqlRetirementPeriod, String.class);                                          //  выполнение запрос
            String lastEntries = template.queryForObject(sqlLastEntries, String.class);                                              //  выполнение запрос

            LocalDateTime retirementPeriod = LocalDateTime.parse(timePeriod);                                                                // парсинг в LocalDateTime
            LocalDateTime dateAndTime = LocalDateTime.parse(lastEntries);                                                                   // парсинг в LocalDateTime
            LocalDateTime retirementPeriodTime = dateAndTime.plusYears(retirementPeriod.getYear()).                                         // определяем дату списания
                    plusMonths(retirementPeriod.getMonthValue()).plusDays(retirementPeriod.getDayOfMonth());
            long milliSecondsFutureWriteOffs = Timestamp.valueOf(retirementPeriodTime).getTime();
            if (currentTimeMilliSeconds >= milliSecondsFutureWriteOffs) {                                                                   // определяем нужно ли списание
                entries.create(idInstructionRegularPayment);
            }
        }
    }
}
