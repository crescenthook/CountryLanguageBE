package com.infy.GetLanguage.service;

import java.util.List;

public interface CountryLanguageService {
	
	List <String> getCountryLanguages(String country_name);
	
	void updateCountryLanguage(String language, Integer countryId);

}
