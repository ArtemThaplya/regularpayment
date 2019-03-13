package com.tsaplya.service.entries;

import com.tsaplya.service.model.InstructionRegularPayment;
import com.tsaplya.service.model.TransactionEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ConfigurationProperties("service")
public class Entries {
    private final Date date = new Date();
    private final JdbcTemplate template;

    @Autowired
    public Entries(final JdbcTemplate template) {
        this.template = template;
    }

    /**
     * Создание проводки по платежу. Запрос к ДБ для создания строки проводки.
     */
    public int create(int idInstructionRegularPayment) {
        String sql = "SELECT amountOfPayment FROM RegularPayment WHERE id=" + idInstructionRegularPayment + "";
        InstructionRegularPayment instruction = template.queryForObject(sql, new Object[]{idInstructionRegularPayment}, new BeanPropertyRowMapper<>(InstructionRegularPayment.class));  //получаем объект с БД
        String create = "INSERT INTO Entries (idInstructionRegularPayment, dateAndTime, amountOfPayment, status)"
                + "VALUES('" + idInstructionRegularPayment + ",'" + date
                + ",'" + instruction.getAmountOfPayment() + ",'" + true + "')";
        return template.update(create);
    }

    /**
     * Запрос к ДБ для изминения строки.
     */
    public int update(TransactionEntries transactionEntries, int id) {
        String update = "UPDATE Entries SET idInstructionRegularPayment='" + transactionEntries.getIdInstructionRegularPayment()
                + "',idInstructionRegularPayment='" + transactionEntries.getIdInstructionRegularPayment()
                + "',amountOfPayment='" + transactionEntries.getAmountOfPayment()
                + "',status='" + transactionEntries.getStatus()
                + "' WHERE id=" + transactionEntries.getId() + "";
        return template.update(update);
    }

    /**
     * Запрос к ДБ для удаления строки
     */
    public int delete(int id) {
        String delete = "DELETE FROM Entries WHERE id=" + id + "";
        return template.update(delete);
    }
}
