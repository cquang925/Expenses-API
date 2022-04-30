package com.phantasosoneiroi.expenses_api;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public ExpenseModel save(ExpenseModel expense) {
        dynamoDBMapper.save(expense);
        return expense;
    }

    public ExpenseModel getExpenseById(String expenseId) {
        return dynamoDBMapper.load(ExpenseModel.class, expenseId);
    }

    public String delete(String expenseId) {
        ExpenseModel exp = dynamoDBMapper.load(ExpenseModel.class, expenseId);
        dynamoDBMapper.delete(exp);
        return "Expense Deleted";
    }

    // Getting error when trying to call method.
    // public String update(String expenseId, ExpenseModel expense) {
    //     dynamoDBMapper.save(expense, 
    //         new DynamoDBSaveExpression()
    //     .withExpectedEntry("expenseId", 
    //         new ExpectedAttributeValue(
    //             new AttributeValue().withS(expenseId)
    //         )));
    //     return expenseId;
    // }
}