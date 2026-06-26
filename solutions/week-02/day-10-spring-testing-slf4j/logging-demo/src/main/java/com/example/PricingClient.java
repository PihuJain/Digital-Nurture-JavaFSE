package com.example;

// dependency for the OrderService, mocked in the @InjectMocks test
public interface PricingClient {

    double priceFor(String sku);
}
