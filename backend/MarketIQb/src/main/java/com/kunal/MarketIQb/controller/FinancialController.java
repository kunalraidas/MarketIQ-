package com.kunal.MarketIQb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FinancialController {
    // ----------- /api/search -----------
    @GetMapping("/api/search")
    public Instrument search(@RequestParam String query) {
        // TODO: replace with real API call
        return new Instrument("Bitcoin", "BTC", 21000.00);
    }

    // ----------- /stocks/hello -----------
    @GetMapping("/stocks/hello")
    public String hello() {
        return "Backend is working!";
    }

    // ----------- DTO Class -----------
    static class Instrument {
        private String name;
        private String symbol;
        private double price;

        public Instrument(String name, String symbol, double price) {
            this.name = name;
            this.symbol = symbol;
            this.price = price;
        }

        // Getters for JSON serialization
        public String getName() { return name; }
        public String getSymbol() { return symbol; }
        public double getPrice() { return price; }

        // Optional setters
        public void setName(String name) { this.name = name; }
        public void setSymbol(String symbol) { this.symbol = symbol; }
        public void setPrice(double price) { this.price = price; }
    }
}
