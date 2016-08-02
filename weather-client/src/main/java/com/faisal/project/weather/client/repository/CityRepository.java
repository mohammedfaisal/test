package com.faisal.project.weather.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faisal.project.weather.client.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
