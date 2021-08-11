package com.covid.model.dao;

import java.util.List;

import com.covid.exception.NotFoundCovidDaily;
import com.covid.model.CovidDaily;

public interface ICovidDaily {
	List<CovidDaily> getAllDailyInfo();
	CovidDaily findByCovidDailyId(Long id) throws NotFoundCovidDaily;
	void create(CovidDaily covidDaily);
	CovidDaily update(CovidDaily covidDaily);
	void delete(Long id);
}
