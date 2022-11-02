package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Inquiry;
import com.example.demo.repository.InquiryDao;

/*
 * Add an annotation here
 */
public class InquiryServiceImpl implements InquiryService {

	private final InquiryDao dao;

	public InquiryServiceImpl(InquiryDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Inquiry inquiry) {
		//hands-on
	}

//  This method is used in the latter chapter
//	@Override
//	public void update(Inquiry inquiry) {
//
//		//return dao.updateInquiry(inquiry);
//		if(dao.updateInquiry(inquiry) == 0) {
//			throw new InquiryNotFoundException("can't find the same ID");
//		}
//	}

	@Override
	public List<Inquiry> getAll() {

		//hands-on

		return null;
	}
}
