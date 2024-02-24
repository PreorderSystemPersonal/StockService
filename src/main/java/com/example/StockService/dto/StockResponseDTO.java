package com.example.StockService.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockResponseDTO {
    private Long productId;
    private Long count;
}
