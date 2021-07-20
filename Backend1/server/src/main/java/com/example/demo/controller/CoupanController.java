package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CoupanDto;
import com.example.demo.entity.Coupan;
import com.example.demo.service.CoupanService;

@RestController
public class CoupanController {

	@Autowired
	private CoupanService ser;
	
	@PostMapping("/addCoupan")
	public Coupan addCoupan(@RequestBody CoupanDto coup) {
		return ser.addCoupans(coup.getCoupan());
	}
	
	@GetMapping("/viewAllCoupans")
	public List<Coupan> viewCoupans(){
		return ser.viewCoupans();
	}
	
	@PostMapping("/editCoupan")
	public Coupan editCoupan(@RequestBody CoupanDto coup) {
		return ser.editCoupans(coup.getCoupan());
	}
	
}
