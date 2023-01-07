package com.in28minutes.springboot.restfulwedservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningpersonController {

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersoinOfPerson() {
		return new PersonV1("john Doe");
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersoinOfPerson() {
		return new PersonV2(new Name("john", "Doe"));
	}

	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersoinOfPersonRequestParameter() {
		return new PersonV1("john Doe");
	}

	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersoinOfPersonRequestParameter() {
		return new PersonV2(new Name("john", "Doe"));
	}
	
	@GetMapping(path = "/person", headers = "X-API-version=1")
	public PersonV1 getFirstVersoinOfPersonRequestheaders() {
		return new PersonV1("john Doe");
	}
	
	@GetMapping(path = "/person", headers = "X-API-version=2")
	public PersonV2 getSecondVersoinOfPersonRequestHeader() {
		return new PersonV2(new Name("john", "Doe"));
	}
}
