package com.example.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.ContactUs;
import com.example.Repository.ContactUsRepository;
import com.example.Service.ContactUsSevice;

@Service
public class ContactUsServiceImpl implements ContactUsSevice{

	@Autowired
	private ContactUsRepository contactUsRepository;
	
	
	@Override
	public ContactUs saveContactUs(ContactUs contactUs) {
		
		return contactUsRepository.save(contactUs);
	}

	@Override
	public List<ContactUs> getAllContactUs() {
		return contactUsRepository.getAll();
	}

	@Override
	public ContactUs getContactById(int id) {
		return contactUsRepository.findById(id);
	}

	@Override
	public ContactUs deleteContactUsById(int id) {
		ContactUs contactUs = contactUsRepository.findById(id);
			contactUs.setDeleted(true);
		return contactUsRepository.save(contactUs);
	}

	@Override
	public ContactUs updateContactById(ContactUs contactUs, int id) {
		contactUs.setId(id);
		return contactUsRepository.save(contactUs);
	}

}
