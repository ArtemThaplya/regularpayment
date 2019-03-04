package com.tsaplya;

import com.tsaplya.beans.TransactionEntries;
import com.tsaplya.entries.Entries;
import com.tsaplya.payments.VerificationWriteOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

public class WriteOffPayment {
    @Autowired
    private TransactionEntries regularPayment;
    @Autowired
    private Entries entries;
    @Autowired
    private JdbcTemplate template;
    private VerificationWriteOff verificationWriteOff;

    @RequestMapping("/creatingPaymentEntries/{id}")
    public String creatingEntriesOfPayment(int idInstructionRegularPayment) {                      // cоздание проводки по платежу
        entries.create(idInstructionRegularPayment);
        return "view";
    }

    @RequestMapping("/verification/{id}")
    public String verificationOfNeedForWriteOff(int idInstructionRegularPayment) {                                  // проверка необходимости списания
        long currentTimeMilliSeconds = System.currentTimeMillis();                                                          // текущеее время
        long milliSecondsFutureWriteOffs = verificationWriteOff.verificationOfNeedForWriteOffOrNot(idInstructionRegularPayment);
        if (currentTimeMilliSeconds >= milliSecondsFutureWriteOffs) {
            return "redirect:/creatingPaymentWires/{id}";
        }
        return "view";
    }

    @RequestMapping("/deleteEntries/{id}")
    public String deleteEntries(int id) {                      //cторнирока проводки (удаление)
        entries.delete(id);
        return "view";
    }
}
