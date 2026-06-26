package com.example;

// takes PricingClient through the constructor so @InjectMocks can wire a mock in
public class OrderService {

    private final PricingClient pricing;

    public OrderService(PricingClient pricing) {
        this.pricing = pricing;
    }

    public double total(String sku, int qty) {
        return pricing.priceFor(sku) * qty;
    }
}
