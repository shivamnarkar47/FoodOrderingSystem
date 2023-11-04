package com.foodOrdering.backend.payload.request;

import java.util.Set;

import com.foodOrdering.backend.models.Role;

import jakarta.validation.constraints.*;

public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> roles;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  public SignupRequest(String username, String email,
      String password, String address,
      String city, String state,
      String zip, Set<String> roles) {
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.password = password;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  @NotBlank
  @Size(max = 120)
  private String address;

  @NotBlank
  @Size(max = 120)
  private String city;

  @NotBlank
  @Size(max = 120)
  private String state;

  @NotBlank
  @Size(max = 120)
  private String zip;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRoles() {
    return this.roles;
  }

  public void setRole(Set<String> roles) {
    this.roles = roles;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

}
