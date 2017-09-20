package com.springbootdemo.adeveloperdiary;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/judoka")
public class JudokaApiService {
	
	public final static Logger logger = LoggerFactory.getLogger(JudokaApiService.class);
	public JudokaRepositoryService service;
	
	public JudokaApiService() {
		service = new JudokaRepositoryService();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Judoka> getAllJudokas() {
		logger.info("HALOOOOO OKA OKA OKA - getAllJudokas()");
		List<Judoka> datas = service.findAll();
		logger.info("OKA GO GO GO!");
		logger.info(datas.toString());
		return datas;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Judoka addJudoka() {
		Judoka judoka = new Judoka();
		judoka.setName("Mark Huizinga");
		judoka.setCountry_origin("Netherlands");
		judoka.setPhoto_profile_url_path("mark-huizinga.png");
		
		service.create(judoka);
		return judoka;
	}
	
}
