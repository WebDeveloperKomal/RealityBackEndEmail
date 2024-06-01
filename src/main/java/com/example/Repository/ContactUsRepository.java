package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entity.ContactUs;

import jakarta.persistence.Id;

public interface ContactUsRepository extends JpaRepository<ContactUs, Integer> {

	
	@Query("SELECT c FROM ContactUs c WHERE c.id = :id AND c.isDeleted = false")
	public ContactUs  findById(@Param("id")int id);
	
	@Query("SELECT c FROM ContactUs c WHERE c.isDeleted = false")
	public List<ContactUs>  getAll();
	
//	  @Query("DELETE aw FROM ContactUs aw WHERE aw.id = :id AND aw.isDeleted = false")
	ContactUs deleteById(@Param("id") int id);
}
