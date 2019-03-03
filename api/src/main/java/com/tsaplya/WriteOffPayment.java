package com.tsaplya;

import com.tsaplya.beans.TransactionEntries;
import com.tsaplya.entries.Entries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class WriteOffPayment {
    @Autowired
    private TransactionEntries regularPayment;
    @Autowired
    private Entries entries;
    @Autowired
    private JdbcTemplate template;

    @RequestMapping("/creatingPaymentWires/{id}")
    public String creatingPaymentOFWires(int idInstructionRegularPayment) {                      // cоздание проводки по платежу
        entries.create(idInstructionRegularPayment);
        return "view";
    }

    @RequestMapping("/verification/{id}")
    public String verificationOfNeedForWriteOff(int idInstructionRegularPayment) {                                  // проверка необходимости списания
        String sqlRetirementPeriod = "SELECT retirementPeriod FROM RegularPayment WHERE  id=" + idInstructionRegularPayment + "";   // дата списания
        String sqlLastEntries = "SELECT dateAndTime FROM Entries WHERE idInstructionRegularPayment=" + idInstructionRegularPayment + "";  // последнее списание
        String timePeriod = (String) template.queryForObject(sqlRetirementPeriod, String.class);                            //  выполнение запрос
        String lastEntries = (String) template.queryForObject(sqlLastEntries, String.class);
        long currentTimeMilliSeconds = System.currentTimeMillis();                                                          // текущеее время

        LocalDateTime retirementPeriod = LocalDateTime.parse(timePeriod);
        LocalDateTime dateAndTime = LocalDateTime.parse(lastEntries);

        LocalDateTime retirementPeriodTime = dateAndTime.plusYears(retirementPeriod.getYear()).
                plusMonths(retirementPeriod.getMonthValue()).plusDays(retirementPeriod.getDayOfMonth());
        long milliSecondsFutureWriteOffs = Timestamp.valueOf(retirementPeriodTime).getTime();
        if (currentTimeMilliSeconds >= milliSecondsFutureWriteOffs) {
            return "redirect:/creatingPaymentWires/{id}";
        }
        return "view";
    }

    @RequestMapping("/deleteEntries/{id}")
    public String reversalWires(int id) {                                                        //cторнирока проводки (удаление)
        entries.delete(id);
        return "view";
    }
}
