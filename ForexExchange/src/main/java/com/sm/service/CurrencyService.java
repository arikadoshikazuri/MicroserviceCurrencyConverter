package com.sm.service;

import java.util.List;

import com.sm.model.Currency;

public interface CurrencyService {
	
	public Currency addCurrency(Currency currency);
	
	public List<Currency> getCurrency();
	
	public Currency getCurrencyById(int id);
	
	public Currency editCurrency(int id, Currency currency);
	
	public String deleteCurrency(int id);
	
	public double getExchangeRate(String title);
}
