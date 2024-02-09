package com.nighthawk.spring_portfolio.mvc.Income;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double dailyIncome;

    public Income() {}

    public Income(double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}
