package com.covid.service;

import java.util.List;

import com.covid.exception.NotFoundCovidDaily;
import com.covid.model.CovidDaily;

public interface IDaoService {

	List<CovidDaily> getAllDailyInfo();
	CovidDaily findByCovidDailyId(Long id) throws NotFoundCovidDaily;
	void create(CovidDaily covidDaily);
	void update(CovidDaily covidDaily);
	void delete(Long id);
}
