package com.sm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrConvertServiceImple implements CurrConverterService {

	@Override
	public double getExRateInInr(String title) {
		// TODO Auto-generated method stub
		String URL = "http://localhost:8082/api/getExchangeRate/{title}";
		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Double> res = restTemplate.getForEntity(URL, Double.class, map);
		return res.getBody();
	}



	@Override
	public double convertCurrByTitle(double curr, String fromCurr, String toCurr) {
		// TODO Auto-generated method stub
//		💥 Example to convert 20 USD to AED
		

		double exchangeRateFromCurr = this.getExRateInInr(fromCurr);
		

		double fromCurrToInr = curr * exchangeRateFromCurr;
		

		double exchangeRateToCurr = this.getExRateInInr(toCurr);
		

		return (fromCurrToInr/exchangeRateToCurr);
	}
	
	

}
