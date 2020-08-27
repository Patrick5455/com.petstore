package com.petstore.petstoreapp.web;

import com.petstore.petstoreapp.models.Pet;
import com.petstore.petstoreapp.models.Store;
import com.petstore.petstoreapp.service.exceptions.StoreObjectNotPresentException;
import com.petstore.petstoreapp.service.store.storeService.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/list")
    public String getStores(Model model){
        model.addAttribute("storeList", storeService.getAllStore());
        System.out.println(storeService.getAllStore());
        return "store-list";
    }

    @GetMapping("/pets/{id}")
    public String getStorePets(@PathVariable("id") Integer storeId, Model model){

        List<Pet> storePets = null;
        try {
           storePets  = storeService.findStorePets(storeId);
        }
        catch (StoreObjectNotPresentException e){
            return "redirect:/";
        }
        model.addAttribute("storePets", storePets);
        return "pet-list";
    }

    @GetMapping("/pets/create/{storeId}")
    public String addPetsToStore(@PathVariable("storeId") Integer storeId, Model model){

        // create pet object
        Pet storePet = new Pet();
        Store store = new Store();

        //create store object and set store id
        store.setId(storeId);

        //map store to pet
        storePet.setPetStore(store);

        // return pet attribute
        model.addAttribute("storePet", storePet);

        // return pet create form
        return "create-pet";
    }

    @PostMapping("/pet/save")
    public String savePetToStore(@ModelAttribute("storePet") Pet storePet, Model model) throws StoreObjectNotPresentException{

        log.info("Pet Info --->"+ storePet);

//        storeService.addPets(storePet, storePet.getPetStore().getId());

        return "redirect:/store/list";
    }

}
