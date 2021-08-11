package com.covid.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.covid.exception.NotFoundCovidDaily;
import com.covid.model.CovidDaily;
import com.covid.model.dao.ICovidDaily;

@Repository(value = "covidDailyRepository")
public class CovidDailyRepository implements ICovidDaily {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<CovidDaily> getAllDailyInfo() {
		return entityManager.createQuery("from CovidDaily",CovidDaily.class).getResultList();
	}

	@Override
	public CovidDaily findByCovidDailyId(Long id) throws NotFoundCovidDaily {
		return entityManager.find(CovidDaily.class, id);
	}

	@Override
	public void create(CovidDaily covidDaily) {
		entityManager.persist(covidDaily);;
	}

	@Override
	public CovidDaily update(CovidDaily covidDaily) {
		return entityManager.merge(covidDaily);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(CovidDaily.class, id));
	}

}
