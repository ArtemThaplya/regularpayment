package com.tsaplya.PaymentDataGetting;

import com.tsaplya.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WriteOffPayment {
    private final AccessService accessService;

    @Autowired
    public WriteOffPayment(AccessService accessService) {
        this.accessService = accessService;
    }

    /**
     * Создание проводки по платежу
     */
    @RequestMapping("/creatingPaymentEntries/{id}")
    public String creatingEntriesOfPayment(@PathVariable("id") int id) {
        accessService.create(id);
        return "view";
    }

    /**
     * Проверка необходимости списания. Текущеее время
     */
    @RequestMapping("/verification/{id}")
    public String verificationOfNeedForWriteOff(@PathVariable("id") int idInstructionRegularPayment) {
        long currentTimeMilliSeconds = System.currentTimeMillis();
        long milliSecondsFutureWriteOffs = accessService.verificationOfNeedForWriteOffOrNot(idInstructionRegularPayment);
        if (currentTimeMilliSeconds >= milliSecondsFutureWriteOffs) {
            return "redirect:/creatingPaymentWires/{id}";
        }
        return "view";
    }

    /**
     * Сторнирока проводки (удаление)
     */
    @RequestMapping("/deleteEntries/{id}")
    public String deleteEntries( @PathVariable("id") int id) {
        accessService.delete(id);
        return "view";
    }
}
