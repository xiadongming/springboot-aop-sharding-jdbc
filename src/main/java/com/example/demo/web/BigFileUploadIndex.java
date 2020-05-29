package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/web")
public class BigFileUploadIndex {

	@RequestMapping("/uploadhtml")
	public String getStringWeb() {
		System.out.println("首页面");

		//return "videoupload";
    //	return "video3";
	//	AmountChange AmountChange = queryAmountServiceImpl.selectOne(ew);
		//return "success2";
		return "videoupload";
	}
	
	
}



