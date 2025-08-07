package com.dc.microservices.currency_exchange_service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
   
    Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
   
    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, 
                                                  @PathVariable String to) {       
       
       logger.info("retrieveExchangeValue method called to convert from {}  to {} ",from,to);                                             // CurrencyExchange exchange = new CurrencyExchange(1l, from, to, new BigDecimal("65.50")); // Example response
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
