package com.training.bean.pack4;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountryHolidays {
	
	private int id;
	private String countryName;
	private Map<String, LocalDate> holidayMap;
	public CountryHolidays(int id, String countryName, Map<String, LocalDate> holidayMap) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.holidayMap = holidayMap;
	}
	public CountryHolidays(String countryName, Map<String, LocalDate> holidayMap) {
		super();
		this.countryName = countryName;
		this.holidayMap = holidayMap;
	}
	public CountryHolidays(int id) {
		super();
		this.id = id;
	}
	public CountryHolidays() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Map<String, LocalDate> getHolidayMap() {
		return holidayMap;
	}
	public void setHolidayMap(Map<String, LocalDate> holidayMap) {
		this.holidayMap = holidayMap;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryHolidays other = (CountryHolidays) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "CountryHolidays [id=" + id + ", countryName=" + countryName + ", holidayMap=" + holidayMap + "]";
	}

	
	
	public void addHoliday(String holidayName, LocalDate holidayDate) {
		if(this.holidayMap==null)
			this.holidayMap=new HashMap<>();
		
		this.holidayMap.put(holidayName, holidayDate);
	}
	
}
