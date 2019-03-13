package com.tsaplya.service.entries;

import com.tsaplya.service.AccessService;
import com.tsaplya.service.model.TransactionEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntriesCreateUpdateDelete {
    private final AccessService accessService;

    @Autowired
    public EntriesCreateUpdateDelete(AccessService accessService) {
        this.accessService = accessService;
    }

    /**
     * Добавление объкта в БД
     */
    @RequestMapping(value = "/createEntries", method = RequestMethod.GET)
    String createEntries(@PathVariable int id) {
        accessService.create(id);
        return "view";
    }

    /**
     * Изменение проводки
     */
    @RequestMapping(value = "/creatingPaymentEntries/{id}", method = RequestMethod.POST)
    public String updateEntries(@ModelAttribute("emp") TransactionEntries emp, int idInstructionRegularPayment) {
        accessService.update(emp, idInstructionRegularPayment);
        return "view";
    }

    /**
     * Удаление объекта с БД
     */
    @RequestMapping(value = "/deletePayment/{id}", method = RequestMethod.GET)
    public String deleteEntries(@PathVariable int id) {
        accessService.delete(id);
        return "redirect:/viewemp";
    }
}
