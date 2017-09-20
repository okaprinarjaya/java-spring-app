package com.springbootdemo.adeveloperdiary;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/judoka")
public class JudokaApiService {
	
	public final static Logger logger = LoggerFactory.getLogger(JudokaApiService.class);
	private static final AtomicLong lastTimeMs = new AtomicLong();
	
	@Autowired
	public JudokaRepositoryService service;
	

	@RequestMapping(method = RequestMethod.GET)
	public List<Judoka> getAllJudokas() {
		List<Judoka> datas = service.findAll();
		return datas;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addJudoka(@RequestBody Judoka judoka) {
		judoka.setId("judoka-" + uniqueCurrentTimeMs());
		service.create(judoka);
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
	}
	
	private static long uniqueCurrentTimeMs() {
		long now = System.currentTimeMillis();
		while (true) {
			long lastTime = lastTimeMs.get();
			if (lastTime >= now) {
				now = lastTime + 1;
			}
			if (lastTimeMs.compareAndSet(lastTime, now)) {
				return now;
			}
		}
	}
	
}
