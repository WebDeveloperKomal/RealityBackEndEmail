package com.example.Entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactUs {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String subject;
	private String email;
	private String message;
	
	@Column(name = "is_deleted", nullable = false)
	private boolean isDeleted;
	    
	@Column(name = "insert_time", updatable = false)
	@CreationTimestamp
	private Date insertTime = new Date(id);
	
	
}
