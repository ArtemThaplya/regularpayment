package com.tsaplya.service.entries;

import com.tsaplya.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntriesByParameter {
    private final AccessService accessService;

    @Autowired
    public EntriesByParameter(AccessService accessService) {
        this.accessService = accessService;
    }

    /**
     * Получения списка проводок по платежу
     */
    @RequestMapping(value = "/entriesByPayment/{id}", method = RequestMethod.GET)
    public String entriesByPayment(@PathVariable long id) {
        accessService.receivingEntriesByPayment(id);
        return "view";
    }

    /**
     * Получение истории списания платежа
     */
    @RequestMapping(value = "/entries/{id}", method = RequestMethod.GET)
    public String entriesByID(@PathVariable long id) {
        accessService.receivingEntriesByID(id);
        return "view";
    }


}
