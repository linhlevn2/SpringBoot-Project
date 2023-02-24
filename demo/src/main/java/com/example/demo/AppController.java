package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path = "/home")
public class AppController{
    @Autowired
    private CostRepository costRepository;
    /* 
    @GetMapping("/home")
    public String home() {
      return "index";
    }
    */
    @GetMapping(path="/all")
    public @ResponseBody Iterable<FoodCost> getAllFoodCost(){
      return costRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody String addFoodCost (@RequestParam Integer boh_cost, @RequestParam Integer foh_cost){
      FoodCost c = new FoodCost();
      c.setBohCost(boh_cost);
      c.setFohCost(foh_cost);
      costRepository.save(c);
      return "Created!";
    }


    /* 
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

