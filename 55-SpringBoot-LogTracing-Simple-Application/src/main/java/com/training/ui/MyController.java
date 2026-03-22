package com.training.ui;






import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
	
	private static final Logger LOG = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	 private RestTemplate restTemplate;
	
	@GetMapping("/check1")
	 public String check1() {
		//LOG.info("check1 service called....");
	 return "The api executed successfully";
	 }
	
	@GetMapping("/check2")
	 public String check2() {
		//LOG.info("check2 service called....");
		String url="http://localhost:8080/check1";
		String result=this.restTemplate.getForObject(url, String.class);
		return result.toUpperCase();
	 }


}
