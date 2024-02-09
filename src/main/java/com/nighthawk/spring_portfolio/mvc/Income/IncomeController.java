package com.nighthawk.spring_portfolio.mvc.Income;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    private final IncomeRepository incomeRepository;

    public IncomeController(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @PostMapping
    public Income logIncome(@RequestBody Income income) {
        return incomeRepository.save(income);
    }
}
