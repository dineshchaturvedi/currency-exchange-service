package com.dc.microservices.currency_exchange_service;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, 
                                                  @PathVariable String to) {
        // Logic to get the exchange rate from a service or database
        // return "Exchange rate from " + from + " to " + to + " is 74.85"; // Example response
        return new CurrencyExchange(1l,from,to, new BigDecimal("65.50")); // Example response
    }
}
