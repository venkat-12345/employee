package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Coupan;
import com.example.demo.repository.CoupanRepository;

@Service
public class CoupanService {
	@Autowired
	public CoupanRepository rep;

	public Coupan addCoupans(Coupan coupan) {
		return rep.save(coupan);
	}
	public Coupan editCoupans(Coupan coupan) {
		Coupan k=rep.getById(coupan.getCoupanid());
		k.setCoupaanDescription(coupan.getCoupaanDescription());
		k.setCoupanName(coupan.getCoupanName());
		k.setCoupanPizzaid(coupan.getCoupanPizzaid());
		k.setCoupanType(coupan.getCoupanType());
		return rep.save(k);
	}
	public Coupan deleteCoupans(int id) {
		var coupan= rep.findById(id).orElse(null);
		rep.deleteById(id);
		return coupan;
	}
	public List<Coupan> viewCoupans() {
		return rep.findAll();
	}
	
}
