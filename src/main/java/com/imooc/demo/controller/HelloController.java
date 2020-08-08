package com.imooc.demo.controller;

import com.imooc.demo.domain.Girl;
import com.imooc.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
	@Autowired
	private GirlRepository girlRepository;
	@GetMapping(value = "/good")
	//@RequestMapping(value = "/good",method = RequestMethod.GET)
	//public String say(@PathVariable("id") Integer Id)
	public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
		return "Id:"+id;
		//return GirlProperties.getCupsize();
	}
	@GetMapping(value = "/html")
	public void girl1() {
		Girl girl = new Girl();
		girl.setId(1);
		System.out.println(girl);
	}
//	public Object tomcat(){
//		return hello.html;
//	}
}
