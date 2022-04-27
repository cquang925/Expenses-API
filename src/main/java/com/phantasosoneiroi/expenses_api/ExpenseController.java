package com.phantasosoneiroi.expenses_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class ExpenseController {
    
    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("getexpenses")
    public List < ExpenseModel > getExpenses() {
        return this.expenseRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="addexpense")
    public void addExpense(@RequestBody ExpenseModel expense) {
        this.expenseRepository.save(expense);
    } 
}
