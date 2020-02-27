package com.kylejudd.football.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kylejudd.football.entity.ProfilePicture;
import com.kylejudd.football.validation.FieldMatch;
import com.kylejudd.football.validation.ValidEmail;

@FieldMatch.List({
	@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CustomUser {
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String matchingPassword;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String username;
	
	@ValidEmail
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String email;
	
	private ProfilePicture profilePicture;
	
	public CustomUser() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public ProfilePicture getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(ProfilePicture profilePicture) {
		this.profilePicture = profilePicture;
	}

	@Override
	public String toString() {
		return "CustomUser [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", matchingPassword=" + matchingPassword + ", username=" + username + ", email=" + email
				+ ", profilePicture=" + profilePicture + "]";
	}

}
