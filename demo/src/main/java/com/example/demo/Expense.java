package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="expense")
public class Expense {
    @Id
    private Integer date;
    private Integer utility;
    private Integer rent;
    private Integer marketing;
    private Integer pos_system;
    private Integer accounting;
    private Integer equipment;
    private Integer maintainance;

    public Expense(){}

    public Expense(Integer date, Integer utility, Integer rent, Integer marketing, 
    Integer pos_system, Integer accounting, Integer equipment, Integer maintainance){
        this.setDate(date);
        this.setUtility(utility);
        this.setRent(rent);
        this.setMarketing(marketing);
        this.setPosSystem(pos_system);
        this.setAccounting(accounting);
        this.setEquipment(equipment);
        this.setMaintainance(maintainance);
    }

    public void setMaintainance(Integer maintainance) {
        this.maintainance = maintainance;
    }

    public void setEquipment(Integer equipment) {
        this.equipment = equipment;
    }

    public void setAccounting(Integer accounting) {
        this.accounting = accounting;
    }

    public void setPosSystem(Integer pos_system) {
        this.pos_system = pos_system;
    }

    public void setMarketing(Integer marketing) {
        this.marketing = marketing;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public void setUtility(Integer utility) {
        this.utility = utility;
    }

    public void setDate(Integer date){
        this.date = date;
    }
    public Integer getDate(){
        return date;
    }

    public Integer getMaintainance() {
        return maintainance;
    }

    public Integer getEquipment() {
        return equipment;
    }

    public Integer getAccounting() {
        return accounting;
    }

    public Integer getPosSystem() {
        return pos_system;
    }

    public Integer getMarketing() {
        return marketing;
    }

    public Integer getRent() {
        return rent;
    }

    public Integer getUtility() {
        return utility;
    }

    


}