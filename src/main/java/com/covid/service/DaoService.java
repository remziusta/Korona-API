package com.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.covid.exception.NotFoundCovidDaily;
import com.covid.model.CovidDaily;
import com.covid.model.dao.jpa.CovidDailyRepository;

public class DaoService implements IDaoService {

	CovidDailyRepository covidDailyRepository;
	
	@Autowired
	public void setCovidDailyRepository(CovidDailyRepository covidDailyRepository) {
		this.covidDailyRepository = covidDailyRepository;
	}
	
	@Override
	public List<CovidDaily> getAllDailyInfo() {
		return covidDailyRepository.getAllDailyInfo();
	}

	@Override
	public CovidDaily findByCovidDailyId(Long id) throws NotFoundCovidDaily {
		return covidDailyRepository.findByCovidDailyId(id);
	}

	@Override
	public void create(CovidDaily covidDaily) {
		covidDailyRepository.create(covidDaily);
	}

	@Override
	public void update(CovidDaily covidDaily) {
		covidDailyRepository.update(covidDaily);
	}

	@Override
	public void delete(Long id) {
		covidDailyRepository.delete(id);
	}

}
