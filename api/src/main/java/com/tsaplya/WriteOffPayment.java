package com.tsaplya;

import com.tsaplya.entries.Entries;
import com.tsaplya.payments.VerificationWriteOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

public class WriteOffPayment {
    private Entries entries = new Entries();
    private VerificationWriteOff verificationWriteOff = new VerificationWriteOff();
    @Autowired
    private JdbcTemplate template;

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
