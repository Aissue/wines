package com.wines.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class collectionSpringTest {
	private List<String> names;
	private Set<String> cities;
	private Map<String,Integer> greads;
	
	
	public Map<String, Integer> getGreads() {
		return greads;
	}
	public void setGreads(Map<String, Integer> greads) {
		this.greads = greads;
	}
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public Set<String> getCities() {
		return cities;
	}
	public void setCities(Set<String> cities) {
		this.cities = cities;
	}
	@Override
	public String toString() {
		return names.get(0)+"|"+cities.toString();
	}
	
	
	
	
	
}
