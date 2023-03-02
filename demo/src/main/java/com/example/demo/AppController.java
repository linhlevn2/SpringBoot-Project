package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;


@Controller
public class AppController{
    @Autowired
    private FoodCostRepository foodcostRepository;
    @Autowired
    private LaborCostRepository laborcostRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    
    @GetMapping(path="/home")
    public String home() {
      return "index";
    }
    
    @GetMapping(path="/all")
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public String viewAllCost(Model model){
      Iterable<FoodCost> foodcost = foodcostRepository.findAll();
      model.addAttribute("foodcost", foodcost);
      return "index";
    }

    @GetMapping(path="/insertCost")
    public String addCostForm(Model model){
      model.addAttribute("foodcost", new FoodCost());
      model.addAttribute("laborcost", new LaborCost());
      model.addAttribute("expense", new Expense());
      return "insertCost";
    }
    
    @PostMapping(path="/insertFoodCost")
    public String add(@ModelAttribute FoodCost foodcost, Model model){
      FoodCost foodcost_inserted = foodcostRepository.save(foodcost);
      model.addAttribute("boh_food_cost", foodcost_inserted.getBohCost());
      model.addAttribute("foh_food_cost", foodcost_inserted.getFohCost());
      return "result";
    }
    
    @PostMapping(path="/insertLaborCost")
    public String add(@ModelAttribute LaborCost laborcost, Model model){
      LaborCost laborcost_inserted = laborcostRepository.save(laborcost);
      model.addAttribute("boh_labor_cost", laborcost_inserted.getBohCost());
      model.addAttribute("foh_labor_cost", laborcost_inserted.getFohCost());
      return "result";
    }

    @PostMapping(path="/insertExpense")
    public String add(@ModelAttribute Expense expense, Model model){
      Expense expense_inserted = expenseRepository.save(expense);
      model.addAttribute("utility", expense_inserted.getUtility());
      model.addAttribute("rent", expense_inserted.getRent());
      return "result";
    }

    /* 
    @PutMapping("/update")
    public FoodCost update(@PathVariable String date, @RequestBody Map<Integer,Integer> body){
      FoodCost cost = costRespository.findOne(date);
      cost.setBohCost(body.get("boh_cost"));
      cost.setFohCost(body.get("foh_cost"));
      return costRespository.save(cost);
    }
    */
}

