package com.in28minutes.springboot.restfulwedservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@RequestMapping("/filtering") // no filed2
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

	@RequestMapping("/filtering-list") // no filed1,2
	public MappingJacksonValue filteringList() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value4", "value5", "value6"));
//		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
//		FilterProvider filters = filter(new MappingJacksonValue(list),"field3");
//		mappingJacksonValue.setFilters(filters);
		return filter(new MappingJacksonValue(list), "field3");
	}

	private MappingJacksonValue filter(MappingJacksonValue mappingJacksonValue, String... fields) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}
