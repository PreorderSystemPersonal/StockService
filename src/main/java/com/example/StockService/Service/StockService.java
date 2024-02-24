package com.example.StockService.Service;

import com.example.StockService.dto.StockResponseDTO;
import com.example.StockService.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {

    @Autowired
    private final RedisUtil redisUtil;

    //재고 생성
    public void create(Long productId, Long stock) {
        //redis에 productId,stock 재고 저장
        redisUtil.setData(productId, stock);

    }

    //재고 조회
    @Transactional
    public ResponseEntity<StockResponseDTO> getProductStock(Long productId) {
        // productId에 해당하는 재고 정보를 Redis에서 가져오기
        Long stockCount = redisUtil.getData(productId);

        // StockResponseDTO 객체를 생성하여 재고 정보를 담기
        StockResponseDTO stockResponseDTO = StockResponseDTO.builder()
                .productId(productId)
                .count(stockCount)
                .build();

        return ResponseEntity.ok(stockResponseDTO);
    }


    public void increase(Long productId, Long stock) {
        // Redis에서 productId에 해당하는 현재 stock을 가져오기
        Long currentStock = redisUtil.getData(productId);

        // stock을 1 증가시킨 값을 Redis에 다시 저장하기
        redisUtil.setData(productId, currentStock + 1);
    }

    public void decrease(Long productId, Long stock) {
        // Redis에서 productId에 해당하는 현재 stock을 가져오기
        Long currentStock = redisUtil.getData(productId);

        // currentstock이 음수일때 errorcode를 작성!!

        // stock을 1 증가시킨 값을 Redis에 다시 저장하기
        redisUtil.setData(productId, currentStock - 1);
    }
}
