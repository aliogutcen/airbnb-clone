package com.ogutcenali.controller;

import com.ogutcenali.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;



}
