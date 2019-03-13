package com.tsaplya.service.entries;

import com.tsaplya.service.model.InstructionRegularPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Component
@ConfigurationProperties("service")
public class StartWriteOff {
    private final JdbcTemplate template;
    private final Entries entries;

    @Autowired
    public StartWriteOff(final JdbcTemplate template, final Entries entries) {
        this.template = template;
        this.entries = entries;
    }

    /**
     * Выбор всех платежей.
     */
    public List<InstructionRegularPayment> allPayments() {
        return template.query("SELECT * FROM RegularPayment", (ResultSet rs, int row) -> {
            InstructionRegularPayment e = new InstructionRegularPayment();
            e.setId(rs.getInt(1));
            e.setFullName(rs.getString(2));
            e.setINN(rs.getLong(3));
            e.setCardNumber(rs.getLong(4));
            e.setBeneficiarysCurrentAccount(rs.getString(5));
            e.setMFO(rs.getInt(6));
            e.setOKPO(rs.getInt(7));
            e.setRecipientsName(rs.getString(8));
            e.setRetirementPeriod(rs.getDate(9));
            e.setAmountOfPayment(rs.getBigDecimal(10));
            return e;
        });
    }

    /**
     * Проврка нужно ли списание. Если да создать проводку.
     */
    public void verificationOfNeedForWriteOffPayment() {
        long currentTimeMilliSeconds = System.currentTimeMillis();                                                          /*Текущеее время*/
        List<InstructionRegularPayment> listRegularPayment = allPayments();                                                 /*Выбор всех платежей, сохранение в списке*/
        for (InstructionRegularPayment list : listRegularPayment) {
            int idInstructionRegularPayment = list.getId();
            String sqlRetirementPeriod = "SELECT retirementPeriod FROM RegularPayment WHERE  id=" + idInstructionRegularPayment + "";  /*Дата списания*/
            String sqlLastEntries = "SELECT dateAndTime FROM Entries WHERE idInstructionRegularPayment=" + idInstructionRegularPayment + "";  /*Последнее списание*/
            String timePeriod = template.queryForObject(sqlRetirementPeriod, String.class);                                          /*Выполнение запроса*/
            String lastEntries = template.queryForObject(sqlLastEntries, String.class);                                              /*Выполнение запроса*/

            LocalDateTime retirementPeriod = LocalDateTime.parse(timePeriod);                                                                /*Парсинг в LocalDateTime*/
            LocalDateTime dateAndTime = LocalDateTime.parse(lastEntries);                                                                   /*Парсинг в LocalDateTime*/
            LocalDateTime retirementPeriodTime = dateAndTime.plusYears(retirementPeriod.getYear()).                                         /*Определяем дату списания*/
                    plusMonths(retirementPeriod.getMonthValue()).plusDays(retirementPeriod.getDayOfMonth());
            long milliSecondsFutureWriteOffs = Timestamp.valueOf(retirementPeriodTime).getTime();
            if (currentTimeMilliSeconds >= milliSecondsFutureWriteOffs) {                                                                   /*Определяем нужно ли списание*/
                entries.create(idInstructionRegularPayment);
                System.out.println("Найден платеж. Создаётся проводка.");
            }
            System.out.println("Платежи для проводки не найдены.");
        }
    }
}
