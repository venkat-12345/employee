package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping("/coupan/add")
	public ResponseEntity<Coupan> addCoupan(@RequestBody CoupanDto coup) {
		return new ResponseEntity<>(ser.addCoupans(coup.getCoupan()),HttpStatus.CREATED);
	}
	
	@GetMapping("/coupan/viewAll")
	public ResponseEntity<List<Coupan>> viewCoupans(){
		return new ResponseEntity<>(ser.viewCoupans(),HttpStatus.OK);
	}
	
	@PostMapping("/coupan/edit")
	public ResponseEntity<Coupan> editCoupan(@RequestBody CoupanDto coup) {
		return new ResponseEntity<>(ser.editCoupans(coup.getCoupan()),HttpStatus.OK);
	}
	
}
