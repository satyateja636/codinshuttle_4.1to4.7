package com.codingshuttle.prod_ready_fearures.entities;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
public class PostEntity extends AuditableEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	
//	@NotAudited -this annotation is used when we don't the particular field to be audited, for example if we use this annotation for description it won't be keeping the track of the who modified this description field like thet it works
	private String description;
	
	@PrePersist //this prepersist annotation is default method  JPA-Auditing but if we want the custom method we are doing like below, this is used for updatedBy and updatedAt
	void beforeSave() {
		
	}
	
	@PreUpdate //this also Jpa's annotation
	void beforeUpdate() {
		
	}
	
	@PreRemove
	void beforeDelete() {
		
	}

}
