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
    private Model addAttribute;
    
    @GetMapping(path="/home")
    public String home() {
      return "index";
    }
    
    @GetMapping(path="/historicCosts")
    @RequestMapping(value="/historicCosts", method = RequestMethod.GET)
    public String viewAllCost(Model model){
      Iterable<FoodCost> foodcost = foodcostRepository.findAll();
      Iterable<LaborCost> laborcost = laborcostRepository.findAll();
      Iterable<Expense> expense = expenseRepository.findAll();
      model.addAttribute("foodcost", foodcost);
      model.addAttribute("laborcost", laborcost);
      model.addAttribute("expense", expense);
      return "historicCosts";
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
      foodcostRepository.save(foodcost);
      return "result";
    }
    
    @PostMapping(path="/insertLaborCost")
    public String add(@ModelAttribute LaborCost laborcost, Model model){
      laborcostRepository.save(laborcost);
      return "result";
    }

    @PostMapping(path="/insertExpense")
    public String add(@ModelAttribute Expense expense, Model model){
      expenseRepository.save(expense);
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

