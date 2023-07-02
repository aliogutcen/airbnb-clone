package com.ogutcenali.controller;

import com.ogutcenali.dto.request.CreateInventory;
import com.ogutcenali.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


    public Boolean createInventory(@Argument CreateInventory createInventory){
        inventoryService.createInventory(createInventory);
        return true;
    }
}
