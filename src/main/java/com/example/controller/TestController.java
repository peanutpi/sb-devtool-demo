package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Sample;
import com.example.service.TestService;

@RestController
public class TestController {
	@Autowired
	private TestService testService;

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping(value = "/api1", method = RequestMethod.POST)
	public void send1(@RequestBody Sample sample) {
		logger.debug("API1 : request came.");
		testService.send1(sample);
	}

	@RequestMapping(value = "/api2", method = RequestMethod.POST)
	public void send2(@RequestBody Sample sample) {
		testService.send2(sample);

	}

	@RequestMapping(value = "/api3", method = RequestMethod.POST)
	public void send3(@RequestBody Sample sample) {
		testService.send3(sample);

	}

	@RequestMapping(value = "/api4", method = RequestMethod.POST)
	public void send4(@RequestBody Sample sample) {
		testService.send4(sample);
	}
}
