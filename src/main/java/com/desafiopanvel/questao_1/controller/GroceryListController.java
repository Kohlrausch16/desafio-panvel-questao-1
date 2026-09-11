package com.desafiopanvel.questao_1.controller;

import com.desafiopanvel.questao_1.services.GroceryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class GroceryListController {

    @Autowired
    private GroceryListService groceryListService;


}
