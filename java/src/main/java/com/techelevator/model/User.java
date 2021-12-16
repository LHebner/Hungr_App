package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

	   private Long id;
	   private String username;
	   @JsonIgnore
	   private String password;
	   @JsonIgnore
	   private boolean activated;
	   private Set<Authority> authorities = new HashSet<>();

	   
	   public User() { }

	   public User(Long id, String username, String password, String authorities) {
	      this.id = id;
	      this.username = username;
	      this.password = password;
	      this.activated = true;
	   }


	   public Long getId() {
	      return id;
	   }

	   public void setId(Long id) {
	      this.id = id;
	   }

	   public String getUsername() {
	      return username;
	   }

	   public void setUsername(String username) {
	      this.username = username;
	   }

	   public String getPassword() {
	      return password;
	   }

	   public void setPassword(String password) {
	      this.password = password;
	   }

	   public boolean isActivated() {
	      return activated;
	   }

	   public void setActivated(boolean activated) {
	      this.activated = activated;
	   }

	   public Set<Authority> getAuthorities() {
	      return authorities;
	   }

	   public void setAuthorities(Set<Authority> authorities) {
	      this.authorities = authorities;
	   }

	   public void setAuthorities(String authorities) {
	      String[] roles = authorities.split(",");
	      for(String role : roles) {
	         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
	         this.authorities.add(new Authority(authority));
	      }
	   }

	   @Override
	   public boolean equals(Object o) {
	      if (this == o) return true;
	      if (o == null || getClass() != o.getClass()) return false;
	      User user = (User) o;
	      return isActivated() == user.isActivated() &&
	              Objects.equals(getId(), user.getId()) &&
	              Objects.equals(getUsername(), user.getUsername()) &&
	              Objects.equals(getPassword(), user.getPassword()) &&
	              Objects.equals(getAuthorities(), user.getAuthorities());

	   }

	   @Override
	   public int hashCode() {
	      return Objects.hash(getId(), getUsername(), getPassword(), isActivated(), getAuthorities());
	   }

	   @Override
	   public String toString() {
	      return "User{" +
	              "id=" + id +
	              ", username='" + username + '\'' +
	              ", activated=" + activated +
	              ", authorities=" + authorities +
	              '}';
	   }
}