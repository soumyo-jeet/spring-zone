package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PriceCalculator {
        public double calculate(double price, double discount) {
            if(price <= 0)
                throw new IllegalArgumentException("Price must be greater than zero");
            if(discount < 0 || discount > price)
                throw new IllegalArgumentException("discount must be valid");
            return price - ((price * discount) / 100);
        }
}
