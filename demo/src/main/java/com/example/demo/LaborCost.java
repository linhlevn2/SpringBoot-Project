package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="labor_cost")
public class LaborCost {
    @Id
    private Integer date;
    private Integer boh_labor_cost;
    private Integer foh_labor_cost;
    private Integer management_salary;

    public LaborCost(){}

    public LaborCost(Integer date, Integer boh_labor_cost, Integer foh_labor_cost, Integer management_salary){
        this.setDate(date);
        this.setBohCost(boh_labor_cost);
        this.setFohCost(foh_labor_cost);
        this.setMngrSalary(management_salary);
    }

    public Integer getMngrSalary() {
        return management_salary;
    }

    public Integer getBohCost(){
        return boh_labor_cost;
    }

    public Integer getFohCost(){
        return foh_labor_cost;
    }

    public Integer getDate(){
        return date;
    }

    public void setBohCost(Integer boh_labor_cost){
        this.boh_labor_cost = boh_labor_cost;
    }

    public void setFohCost(Integer foh_labor_cost){
        this.foh_labor_cost = foh_labor_cost;
    }

    public void setDate(Integer date){
        this.date = date;
    }

    public void setMngrSalary(Integer management_salary) {
        this.management_salary = management_salary;
    }

}
