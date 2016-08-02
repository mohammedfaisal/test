package com.faisal.project.weather.client.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class City {
	
	@Id
	protected Integer cityId;
	protected String cityName;
	protected String cityZip;
	protected String state;
	protected String country;
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityZip() {
		return cityZip;
	}
	public void setCityZip(String cityZip) {
		this.cityZip = cityZip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", cityZip=" + cityZip + ", state=" + state
				+ ", country=" + country + "]";
	}
	
}
