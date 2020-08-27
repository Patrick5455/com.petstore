package com.petstore.petstoreapp.web;

import com.petstore.petstoreapp.models.Store;
import com.petstore.petstoreapp.service.store.storeService.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    Logger log = Logger.getLogger(getClass().getName());

    @RequestMapping("/form")
    public String getStoreForm(Model model){
       model.addAttribute("store", new Store());
        return "create-store";
    }

    @PostMapping("/create")
    public String createStore(@ModelAttribute("store") Store store,
    Model model){

        log.info("Collected Store info from user --->" + store);
        storeService.save(store);
        model.addAttribute("storeObj", store);
        return "store-info";
    }


}
