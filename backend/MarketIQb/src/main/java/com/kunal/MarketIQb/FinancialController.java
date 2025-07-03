package com.kunal.MarketIQb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FinancialController {

    @GetMapping("/search")
    public Instrument search(@RequestParam String query) {
        // TODO: wire up real API call (CoinGecko, Finnhub, etc.)
        // For now, return dummy data
        return new Instrument("Bitcoin", "BTC", 21000.00);
    }

    // Simple DTO
    static class Instrument {
        private String name;
        private String symbol;
        private double price;

        public Instrument(String name, String symbol, double price) {
            this.name = name;
            this.symbol = symbol;
            this.price = price;
        }
        // getters & setters omitted for brevity
    }
}