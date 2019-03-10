package com.tsaplya.service.entries;

import com.tsaplya.service.model.TransactionEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntriesCreateUpdateDelete {
    private final Entries entries;

    @Autowired
    public EntriesCreateUpdateDelete(Entries entries) {
        this.entries = entries;
    }

    @RequestMapping(value = "/createEntries", method = RequestMethod.GET)
    String createEntries(@PathVariable int id) {           // получение объекта
        entries.create(id);                                                               // добавление объкта в БД
        return "view";
    }

    @RequestMapping(value = "/creatingPaymentEntries/{id}", method = RequestMethod.POST)
    public String updateEntries(@ModelAttribute("emp") TransactionEntries emp, int idInstructionRegularPayment) {                      // изменение проводки
        entries.update(emp, idInstructionRegularPayment);
        return "view";
    }

    @RequestMapping(value = "/deletePayment/{id}", method = RequestMethod.GET)
    public String deleteEntries(@PathVariable int id) {                                     // получение id
        entries.delete(id);                                                               // удаление объекта с БД
        return "redirect:/viewemp";
    }
}
