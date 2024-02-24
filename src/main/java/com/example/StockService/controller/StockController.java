package com.example.StockService.controller;

import com.example.StockService.Service.StockService;
import com.example.StockService.dto.StockResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/StockService")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    //재고 수량 조회
    @GetMapping("product/stock/{id}")
    public ResponseEntity<StockResponseDTO> getProductStock(@PathVariable Long id){
        return ResponseEntity.ok().body(stockService.getProductStock(id).getBody());
    }

}
