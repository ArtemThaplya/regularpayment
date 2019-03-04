package com.tsaplya.payments;

import com.tsaplya.beans.InstructionRegularPayment;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PaymentsCreateUpdateDelete {
    private Payments payments;

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
        payments.delete(id);                                                               // удаление объекта с БД
        return "redirect:/viewemp";
    }
}