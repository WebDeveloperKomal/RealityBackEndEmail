package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.ContactUs;
import com.example.Repository.ContactUsRepository;
import com.example.Service.ContactUsSevice;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class ContactUsCotroller {
	
	private static final Class<Integer> Integer = null;
	
	@Autowired
	private ContactUsSevice contactUsSevice;
	
	/************* Save Contact *************/
	@PostMapping("/save-contact")
	public ResponseEntity<ContactUs> createContactUs(@RequestBody ContactUs contactUs){
		ContactUs saveContactUs = contactUsSevice.saveContactUs(contactUs);
		return ResponseEntity.ok(saveContactUs);
		
	}
	
	/************* Get All Contact List *************/
	@GetMapping("/get-all-contact-list")
	public List<ContactUs> getContactUs(){
		return contactUsSevice.getAllContactUs();
	}
	
	/************* Get By Id Contact List *************/
	@GetMapping("/get-contact/{id}")
	public ContactUs getContactById(@PathVariable("id")int id ) {
		return contactUsSevice.getContactById(id);
	}
	
	
	/************* Delete Contact By Id *************/
	@DeleteMapping("/delete-contact/{id}")
	public ContactUs deleteContact(@PathVariable("id")int id)
	{
		return contactUsSevice.deleteContactUsById(id);
	}
	
	
	/************* Update Contact By Id *************/
	@PutMapping("update-contact/{id}")
	public ResponseEntity<ContactUs> updateContactById(@PathVariable("id")int id, @RequestBody ContactUs updateContact) {
		ContactUs existingContact = contactUsSevice.getContactById(id);
		if(existingContact != null) {
			updateContact.setId(id);
			ContactUs updateContactUs = contactUsSevice.updateContactById(updateContact, id);
			return ResponseEntity.ok(updateContactUs);
		}else {
			 return ResponseEntity.notFound().build();
		}
		
	}
}
