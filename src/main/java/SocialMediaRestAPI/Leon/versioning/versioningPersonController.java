package SocialMediaRestAPI.Leon.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class versioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionPerson() {
		return new PersonV1("Leon Wang");
	}
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionPerson() {
		return new PersonV2("Leon", "Wang");
	}
	
	@GetMapping(value = "/person", params = "version=1")
	public PersonV1 getFirstVersionPersonPara() {
		return new PersonV1("Leon Wang");
	}
	@GetMapping(value = "/person", params = "version=2")
	public PersonV2 getSecondVersionPersonPara() {
		return new PersonV2("Leon","Wang");
	}
	
	
	
}
