package com.tsaplya.PaymentDataGetting;

import com.tsaplya.entries.Entries;
import com.tsaplya.payments.VerificationWriteOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriteOffPayment {
    private final Entries entries;
    private final VerificationWriteOff verificationWriteOff;

    @Autowired
    public WriteOffPayment(Entries entries, VerificationWriteOff verificationWriteOff) {
        this.entries = entries;
        this.verificationWriteOff = verificationWriteOff;
    }

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
