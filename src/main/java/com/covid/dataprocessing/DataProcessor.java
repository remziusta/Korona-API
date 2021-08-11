package com.covid.dataprocessing;



import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;

import com.covid.model.CovidDaily;

public class DataProcessor implements ItemProcessor<DailyInput,CovidDaily> {


	@Override
	public CovidDaily process(DailyInput dailyInput) throws Exception {
		CovidDaily _covidDaily = new CovidDaily();
		
		
		_covidDaily.setID(Long.valueOf(dailyInput.getID()));
		_covidDaily.setDATE(LocalDate.parse(dailyInput.getDATE()));
		_covidDaily.setTOTAL_TEST(Integer.valueOf(dailyInput.getTOTAL_TEST()));
		_covidDaily.setTOTAL_CASE(Integer.valueOf(dailyInput.getTOTAL_CASE()));
		_covidDaily.setTOTAL_DEAD(Integer.valueOf(dailyInput.getTOTAL_DEAD()));
		_covidDaily.setPNEUMONIA_RATE(Float.valueOf(dailyInput.getPNEUMONIA_RATE()));
		_covidDaily.setTOTAL_SERIOUSLY_ILL(Integer.valueOf(dailyInput.getTOTAL_SERIOUSLY_ILL()));
		_covidDaily.setTOTAL_PATIENT_RECOVERING(Integer.valueOf(dailyInput.getTOTAL_PATIENT_RECOVERING()));
		_covidDaily.setTOTAL_CASE_IN_TODAY(Integer.valueOf(dailyInput.getTOTAL_CASE_IN_TODAY()));
		_covidDaily.setTOTAL_ILL_IN_TODAY(Integer.valueOf(dailyInput.getTOTAL_ILL_IN_TODAY()));
		_covidDaily.setTOTAL_TEST_IN_TODAY(Integer.valueOf(dailyInput.getTOTAL_TEST_IN_TODAY()));
		_covidDaily.setTOTAL_DEAD_IN_TODAY(Integer.valueOf(dailyInput.getTOTAL_DEAD_IN_TODAY()));
		_covidDaily.setTOTAL_RECOVERING_IN_TODAY(Integer.valueOf(dailyInput.getTOTAL_RECOVERING_IN_TODAY()));
		
		return _covidDaily;
	}

	

}
