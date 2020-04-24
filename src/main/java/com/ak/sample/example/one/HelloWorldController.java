package com.ak.sample.example.one;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String helloWorld() {
		return "Hello world from /hello call";
	}

	@GetMapping(path = "/hello/{name}")
	public String helloFriend(@PathVariable String name) {
		return "Hello " + name;
	}

	@GetMapping
	public String emptyCall() {
		return "Hello world from empty call";
	}

	@GetMapping(path = "/getBean")
	public MessageBean returnBean() {
		return new MessageBean("Hello world returned from a bean");
	}

}
