package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;


@Controller
public class AppController{
    @Autowired
    private CostRepository costRepository;
    
    @GetMapping(path="/home")
    public String home() {
      return "index";
    }
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<FoodCost> getAllFoodCost(){
      return costRepository.findAll();
    }

    @GetMapping(path="/addCost")
    public String addFoodCostForm(Model model){
      model.addAttribute("foodcost", new FoodCost());
      return "addCost";
    }
    
    @PostMapping(path="/addCost")
    public @ResponseBody String add(@ModelAttribute FoodCost foodcost, Model model){
      System.out.println(foodcost.getBohCost()+"-boh "+ foodcost.getFohCost()+"-foh "+foodcost.getDate());
      FoodCost foodcost_inserted = costRepository.save(foodcost);
      model.addAttribute("boh_food_cost", foodcost_inserted.getBohCost());
      model.addAttribute("foh_food_cost", foodcost_inserted.getFohCost());
      return "result";
    }
    /* 
    @PostMapping(path="/create")
    public String addFoodCost (@ModelAttribute FoodCost foodcost, Model model){
      model.addAttribute("foodcost", foodcost);
      costRepository.save(foodcost);
      return "createResult";
    }
    

     
    @GetMapping("/show")
    public @ResponseBody Iterable<FoodCost> getAllCost(){
      return costRespository.findAll();
    }

    @PostMapping("/create")
    public FoodCost create(@RequestBody FoodCost cost){
      return costRespository.save(cost);
    }

    
    @PutMapping("/update")
    public FoodCost update(@PathVariable String date, @RequestBody Map<Integer,Integer> body){
      FoodCost cost = costRespository.findOne(date);
      cost.setBohCost(body.get("boh_cost"));
      cost.setFohCost(body.get("foh_cost"));
      return costRespository.save(cost);
    }
    */
}

