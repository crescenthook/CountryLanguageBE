package com.infy.GetLanguage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.infy.GetLanguage.entity.CountryLanguage;

import jakarta.transaction.Transactional;

@Repository(value = "CountryRepository")
public interface CountryRepository extends CrudRepository<CountryLanguage, Integer> {

	@Query("Select clt.countryLanguage from CountryLanguage clt where clt.countryName = ?1")
	List <String> getCountryLanguages(String country_name);
	
	@Query("Update CountryLanguage clt Set clt.countryLanguage = :language where clt.countryId = :id")
	@Modifying
	@Transactional
	void updateCountryLanguage(@Param("language")String language, @Param("id")Integer countryId);
}