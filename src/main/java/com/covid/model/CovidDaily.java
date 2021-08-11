package com.covid.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "covid_daily")
public class CovidDaily {
	@Id
	@GeneratedValue(generator = "covidDaily", strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(sequenceName ="COVID_DAILY_DB",name = "covidDaily", allocationSize = 1 )
	private Long ID;
	
	@Column(name = "DATE")
	private LocalDate DATE;
	
	@Column(name = "TOTAL_TEST")
	private int TOTAL_TEST;
	
	@Column(name = "TOTAL_CASE")
	private int TOTAL_CASE;
	
	@Column(name = "TOTAL_DEAD")
	private int TOTAL_DEAD;
	
	@Column(name = "PNEUMONIA_RATE")
	private float PNEUMONIA_RATE;
	
	@Column(name = "TOTAL_SERIOUSLY_ILL")
	private int TOTAL_SERIOUSLY_ILL;
	
	@Column(name = "TOTAL_PATIENT_RECOVERING")
	private int TOTAL_PATIENT_RECOVERING;
	
	@Column(name = "TOTAL_CASE_IN_TODAY")
	private int TOTAL_CASE_IN_TODAY;

	@Column(name = "TOTAL_ILL_IN_TODAY")
	private int TOTAL_ILL_IN_TODAY;
	
	@Column(name = "TOTAL_TEST_IN_TODAY")
	private int TOTAL_TEST_IN_TODAY;
	
	@Column(name = "TOTAL_DEAD_IN_TODAY")
	private int TOTAL_DEAD_IN_TODAY;
	
	@Column(name = "TOTAL_RECOVERING_IN_TODAY")
	private int TOTAL_RECOVERING_IN_TODAY;

	
	
	public CovidDaily() {
		
	}

	public CovidDaily(Long iD, LocalDate dATE, int tOTAL_TEST, int tOTAL_CASE, int tOTAL_DEAD, float pNEUMONIA_RATE,	int tOTAL_SERIOUSLY_ILL, int tOTAL_PATIENT_RECOVERING, int tOTAL_CASE_IN_TODAY, int tOTAL_ILL_IN_TODAY,
			int tOTAL_TEST_IN_TODAY, int tOTAL_DEAD_IN_TODAY, int tOTAL_RECOVERING_IN_TODAY) {
		ID = iD;
		DATE = dATE;
		TOTAL_TEST = tOTAL_TEST;
		TOTAL_CASE = tOTAL_CASE;
		TOTAL_DEAD = tOTAL_DEAD;
		PNEUMONIA_RATE = pNEUMONIA_RATE;
		TOTAL_SERIOUSLY_ILL = tOTAL_SERIOUSLY_ILL;
		TOTAL_PATIENT_RECOVERING = tOTAL_PATIENT_RECOVERING;
		TOTAL_CASE_IN_TODAY = tOTAL_CASE_IN_TODAY;
		TOTAL_ILL_IN_TODAY = tOTAL_ILL_IN_TODAY;
		TOTAL_TEST_IN_TODAY = tOTAL_TEST_IN_TODAY;
		TOTAL_DEAD_IN_TODAY = tOTAL_DEAD_IN_TODAY;
		TOTAL_RECOVERING_IN_TODAY = tOTAL_RECOVERING_IN_TODAY;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public LocalDate getDATE() {
		return DATE;
	}

	public void setDATE(LocalDate dATE) {
		DATE = dATE;
	}

	public int getTOTAL_TEST() {
		return TOTAL_TEST;
	}

	public void setTOTAL_TEST(int tOTAL_TEST) {
		TOTAL_TEST = tOTAL_TEST;
	}

	public int getTOTAL_CASE() {
		return TOTAL_CASE;
	}

	public void setTOTAL_CASE(int tOTAL_CASE) {
		TOTAL_CASE = tOTAL_CASE;
	}

	public int getTOTAL_DEAD() {
		return TOTAL_DEAD;
	}

	public void setTOTAL_DEAD(int tOTAL_DEAD) {
		TOTAL_DEAD = tOTAL_DEAD;
	}

	public float getPNEUMONIA_RATE() {
		return PNEUMONIA_RATE;
	}

	public void setPNEUMONIA_RATE(float pNEUMONIA_RATE) {
		PNEUMONIA_RATE = pNEUMONIA_RATE;
	}

	public int getTOTAL_SERIOUSLY_ILL() {
		return TOTAL_SERIOUSLY_ILL;
	}

	public void setTOTAL_SERIOUSLY_ILL(int tOTAL_SERIOUSLY_ILL) {
		TOTAL_SERIOUSLY_ILL = tOTAL_SERIOUSLY_ILL;
	}

	public int getTOTAL_PATIENT_RECOVERING() {
		return TOTAL_PATIENT_RECOVERING;
	}

	public void setTOTAL_PATIENT_RECOVERING(int tOTAL_PATIENT_RECOVERING) {
		TOTAL_PATIENT_RECOVERING = tOTAL_PATIENT_RECOVERING;
	}

	public int getTOTAL_CASE_IN_TODAY() {
		return TOTAL_CASE_IN_TODAY;
	}

	public void setTOTAL_CASE_IN_TODAY(int tOTAL_CASE_IN_TODAY) {
		TOTAL_CASE_IN_TODAY = tOTAL_CASE_IN_TODAY;
	}

	public int getTOTAL_ILL_IN_TODAY() {
		return TOTAL_ILL_IN_TODAY;
	}

	public void setTOTAL_ILL_IN_TODAY(int tOTAL_ILL_IN_TODAY) {
		TOTAL_ILL_IN_TODAY = tOTAL_ILL_IN_TODAY;
	}

	public int getTOTAL_TEST_IN_TODAY() {
		return TOTAL_TEST_IN_TODAY;
	}

	public void setTOTAL_TEST_IN_TODAY(int tOTAL_TEST_IN_TODAY) {
		TOTAL_TEST_IN_TODAY = tOTAL_TEST_IN_TODAY;
	}

	public int getTOTAL_DEAD_IN_TODAY() {
		return TOTAL_DEAD_IN_TODAY;
	}

	public void setTOTAL_DEAD_IN_TODAY(int tOTAL_DEAD_IN_TODAY) {
		TOTAL_DEAD_IN_TODAY = tOTAL_DEAD_IN_TODAY;
	}

	public int getTOTAL_RECOVERING_IN_TODAY() {
		return TOTAL_RECOVERING_IN_TODAY;
	}

	public void setTOTAL_RECOVERING_IN_TODAY(int tOTAL_RECOVERING_IN_TODAY) {
		TOTAL_RECOVERING_IN_TODAY = tOTAL_RECOVERING_IN_TODAY;
	}
	
	

}
