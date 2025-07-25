package com;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dc.microservices.currency_exchange_service.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository <CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String from, String to);

}
