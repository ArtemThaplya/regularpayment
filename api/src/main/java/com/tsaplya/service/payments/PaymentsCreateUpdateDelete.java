package com.tsaplya.service.payments;

import com.tsaplya.service.AccessService;
import com.tsaplya.service.model.InstructionRegularPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentsCreateUpdateDelete {
    private final AccessService accessService;

    @Autowired
    public PaymentsCreateUpdateDelete(AccessService accessService) {
        this.accessService = accessService;
    }

    /**
     * Добавление объкта в БД
     */
    @RequestMapping(value = "/createPayments", method = RequestMethod.POST)
    String createPayments(@ModelAttribute("emp") InstructionRegularPayment emp) {
        accessService.create(emp);
        return "view";
    }

    /**
     * Изменение объкта в БД
     */
    @RequestMapping(value = "/updatePayments", method = RequestMethod.POST)
    String updatePayments(@ModelAttribute("emp") InstructionRegularPayment emp) {
        accessService.update(emp);
        return "view";
    }

    /**
     * Удаление объекта с БД
     */
    @RequestMapping(value = "/deletePayment/{id}", method = RequestMethod.GET)
    public String deletePayment(@PathVariable int id) {
        accessService.deletePayments(id);
        return "redirect:/viewemp";
    }
}
