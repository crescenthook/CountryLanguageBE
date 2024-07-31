package com.infy.GetLanguage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.GetLanguage.repository.CountryRepository;

@Service(value = "CountryLanguageService")
public class CountryLanguageServiceImpl implements CountryLanguageService {
	
	@Autowired
	private CountryRepository cr;

	@Override
	public List<String> getCountryLanguages(String country_name) {
		
		return cr.getCountryLanguages(country_name);
	}

	@Override
	public void updateCountryLanguage(String language, Integer countryId) {
		
		cr.updateCountryLanguage(language, countryId);
	}

}
