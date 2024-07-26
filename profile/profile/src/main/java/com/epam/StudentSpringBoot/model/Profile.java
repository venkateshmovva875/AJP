package com.epam.StudentSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Profile {
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contactInformation;

    private String bio;

    private String profilePicture;
    
    
    Profile() {
    	
    }
    
    
    

	public Profile(String name, String contactInformation, String bio, String profilePicture) {
		super();
		this.name = name;
		this.contactInformation = contactInformation;
		this.bio = bio;
		this.profilePicture = profilePicture;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}




	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", contactInformation=" + contactInformation + ", bio=" + bio
				+ ", profilePicture=" + profilePicture + "]";
	}
	
	
	
}
