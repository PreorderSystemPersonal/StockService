package com.example.StockService.controller;

import com.example.StockService.Service.StockService;
import com.example.StockService.dto.StockResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/internal/stock")
@RequiredArgsConstructor
public class InternalStockController {
    private final StockService stockService;
    //상품 재고 수량 생성
    @PostMapping
    public ResponseEntity<Void> create(@RequestParam("id") Long productId,@RequestParam("stock") Long stock){
        stockService.create(productId,stock);
        return ResponseEntity.ok().build();
    }

    //상품 재고 증가 - 결제 실패했을 때 다시 증가
    @PostMapping("/increase")
    public ResponseEntity<Void> increase(@RequestParam("id") Long productId,@RequestParam("stock")Long stock){
        stockService.increase(productId,stock);
        return ResponseEntity.ok().build();
    }

    //상품 재고 감소-주문 들어갔을 때 감소 요청
    @PostMapping("/decrease")
    public ResponseEntity<Void> decrease(@RequestParam("id") Long productId,@RequestParam("stock")Long stock){
        stockService.decrease(productId,stock);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockResponseDTO> get(@PathVariable("id") Long productId){
        return ResponseEntity.ok().body(stockService.getProductStock(productId).getBody());
    }
}
