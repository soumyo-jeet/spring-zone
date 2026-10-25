package com.example.demo.service;

import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {
    PriceCalculator priceCalculator = new PriceCalculator();
    @Test
    public void testCalculatePrice() {
        // Arrange
        double price = 100, discount = 20;

        // Act
        double ans = priceCalculator.calculate(price, discount);

        // Assert
        assert(ans == 80);
    }
}
