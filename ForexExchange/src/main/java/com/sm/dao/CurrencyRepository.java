package com.sm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
	
}
