package com.example.StockService.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Entity
//@Table(name="Product_Count_table")
@RedisHash("Stock")
@Getter
@Setter
public class Stock {
    @Id
    private Long productId;

    private Long count;
    public Stock() {
    }

    public Stock(Long productId, Long count) {
        this.productId = productId;
        this.count = count;
    }

    // Getters and setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
