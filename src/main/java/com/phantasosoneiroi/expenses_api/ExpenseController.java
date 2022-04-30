package com.phantasosoneiroi.expenses_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class ExpenseController {
    
    @Autowired
    private ExpenseRepository expenseRepository;

    // @GetMapping("getexpenses")
    // public List < ExpenseModel > getExpenses() {
    //     return this.expenseRepository.findAll();
    // }

    // @RequestMapping(method=RequestMethod.POST, value="addexpense")
    // public void addExpense(@RequestBody ExpenseModel expense) {
    //     this.expenseRepository.save(expense);
    // } 

    @PostMapping("expenses")
    public ExpenseModel saveExpense(@RequestBody ExpenseModel expense) {
        return expenseRepository.save(expense);
    }

    @GetMapping("expenses/{id}")
    public ExpenseModel getExpense(@PathVariable("id") String expenseId) {
        return expenseRepository.getExpenseById(expenseId);
    }

    @DeleteMapping("expenses/{id}")
    public String deleteExpense(@PathVariable("id") String expenseId) {
        return expenseRepository.delete(expenseId);
    }

    // @PutMapping("expenses/{id}")
    // public String updateExpense(@PathVariable("id") String expenseId, @RequestBody ExpenseModel expense) {
    //     return expenseRepository.update(expenseId, expense);
    // }

}
