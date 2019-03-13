package com.tsaplya.service.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
@ConfigurationProperties("service")
public class VerificationWriteOff {
    private final JdbcTemplate template;

    @Autowired
    public VerificationWriteOff(final JdbcTemplate template) {
        this.template = template;
    }

    /**
     * Проврка нужно ли списание.
     */
    public long verificationOfNeedForWriteOffOrNot(int idInstructionRegularPayment) {
        String sqlRetirementPeriod = "SELECT retirementPeriod FROM RegularPayment WHERE  id=" + idInstructionRegularPayment + "";         /*Дата списания*/
        String sqlLastEntries = "SELECT dateAndTime FROM Entries WHERE idInstructionRegularPayment=" + idInstructionRegularPayment + "";  /*Последнее списание*/
        String timePeriod = template.queryForObject(sqlRetirementPeriod, String.class);                                          /*Выполнение запроса*/
        String lastEntries = template.queryForObject(sqlLastEntries, String.class);                                              /*Выполнение запроса*/

        LocalDateTime retirementPeriod = LocalDateTime.parse(timePeriod);                                                                /*Парсинг в LocalDateTime*/
        LocalDateTime dateAndTime = LocalDateTime.parse(lastEntries);                                                                   /*Парсинг в LocalDateTime*/
        LocalDateTime retirementPeriodTime = dateAndTime.plusYears(retirementPeriod.getYear()).                                         /*Определяем дату списания*/
                plusMonths(retirementPeriod.getMonthValue()).plusDays(retirementPeriod.getDayOfMonth());
        return Timestamp.valueOf(retirementPeriodTime).getTime();
    }
}
