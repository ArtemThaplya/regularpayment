package com.tsaplya.service.payments;

import com.tsaplya.service.model.InstructionRegularPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentsCreateUpdateDelete {
    private final Payments payments;

    @Autowired
    public PaymentsCreateUpdateDelete(Payments payments) {
        this.payments = payments;
    }

    @RequestMapping(value = "/createPayments", method = RequestMethod.POST)
    String createPayments(@ModelAttribute("emp") InstructionRegularPayment emp) {           // получение объекта
        payments.create(emp);                                                               // добавление объкта в БД
        return "view";
    }

    @RequestMapping(value = "/updatePayments", method = RequestMethod.POST)
    String updatePayments(@ModelAttribute("emp") InstructionRegularPayment emp) {           // получение объекта
        payments.update(emp);                                                               // изменение объкта в БД
        return "view";
    }

    @RequestMapping(value = "/deletePayment/{id}", method = RequestMethod.GET)
    public String deletePayment(@PathVariable int id) {                                     // получение id
        payments.deletePayments(id);                                                               // удаление объекта с БД
        return "redirect:/viewemp";
    }
}
