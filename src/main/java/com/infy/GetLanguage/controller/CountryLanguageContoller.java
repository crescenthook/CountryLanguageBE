package com.infy.GetLanguage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.GetLanguage.service.CountryLanguageService;
import com.infy.util.UpdateLanguage;

@CrossOrigin
@RestController
@RequestMapping("/country/api")
public class CountryLanguageContoller {
	
	@Autowired
	private CountryLanguageService cls;
	
	//http://localhost:8080/country/api/languages/
	@GetMapping("/languages/{country}")
	public ResponseEntity<List<String>> getLanguagesForCountry(@PathVariable String country){
		
		List<String> languageList = cls.getCountryLanguages(country);
		return new ResponseEntity<>(languageList, HttpStatus.OK);
		
	}
	
	@PutMapping("/languages")
	public ResponseEntity<String> updateCountryLanguage(@RequestBody UpdateLanguage update){
		
		cls.updateCountryLanguage(update.getLanguage(),update.getId());
		String success = "Language Updated Successfully";
		
		return new ResponseEntity<>(success, HttpStatus.OK);
		
	}
}
