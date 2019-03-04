package com.tsaplya.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class VerificationWriteOff {
    @Autowired
    private JdbcTemplate template;

    public long verificationOfNeedForWriteOffOrNot(int idInstructionRegularPayment) {
        String sqlRetirementPeriod = "SELECT retirementPeriod FROM RegularPayment WHERE  id=" + idInstructionRegularPayment + "";         // дата списания
        String sqlLastEntries = "SELECT dateAndTime FROM Entries WHERE idInstructionRegularPayment=" + idInstructionRegularPayment + "";  // последнее списание
        String timePeriod = template.queryForObject(sqlRetirementPeriod, String.class);                                          //  выполнение запрос
        String lastEntries = template.queryForObject(sqlLastEntries, String.class);                                              //  выполнение запрос

        LocalDateTime retirementPeriod = LocalDateTime.parse(timePeriod);                                                                // парсинг в LocalDateTime
        LocalDateTime dateAndTime = LocalDateTime.parse(lastEntries);                                                                   // парсинг в LocalDateTime
        LocalDateTime retirementPeriodTime = dateAndTime.plusYears(retirementPeriod.getYear()).                                         // определяем дату списания
                plusMonths(retirementPeriod.getMonthValue()).plusDays(retirementPeriod.getDayOfMonth());
        return Timestamp.valueOf(retirementPeriodTime).getTime();
    }
}
