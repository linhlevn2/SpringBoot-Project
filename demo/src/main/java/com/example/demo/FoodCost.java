package com.example.demo;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodCost {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer boh_food_cost;
    private Integer foh_food_cost;
    private Integer date;

    public FoodCost(){}

    public FoodCost(Integer date, Integer boh_food_cost, Integer foh_food_cost){
        this.setDate(date);
        this.setBohCost(boh_food_cost);
        this.setFohCost(foh_food_cost);
    }

    public Integer getBohCost(){
        return boh_food_cost;
    }

    public Integer getFohCost(){
        return foh_food_cost;
    }

    public Integer getDate(){
        return date;
    }

    public void setBohCost(Integer boh_food_cost){
        this.boh_food_cost = boh_food_cost;
    }

    public void setFohCost(Integer foh_food_cost){
        this.foh_food_cost = foh_food_cost;
    }

    public void setDate(Integer date){
        this.date = date;
    }

    @Override
    public String toString() {
        return "Food Cost date: " + date + "| BOH: " + boh_food_cost + "FOH: " + foh_food_cost;
    }

}
