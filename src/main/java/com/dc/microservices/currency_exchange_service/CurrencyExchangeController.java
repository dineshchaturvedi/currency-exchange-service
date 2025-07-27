package com.dc.microservices.currency_exchange_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, 
                                                  @PathVariable String to) {       
        // CurrencyExchange exchange = new CurrencyExchange(1l, from, to, new BigDecimal("65.50")); // Example response
        CurrencyExchange exchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if (exchange == null) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }
        String port = environment.getProperty("local.server.port");
        exchange.setEnvironement("Currency Exchange Service running on port: " + port);
        // exchange.setEnvironement();
        return exchange;
    }
}
