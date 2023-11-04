package com.foodOrdering.backend.payload.response;

import java.util.List;

import org.springframework.http.ResponseCookie;

public class UserInfoResponse {
  private ResponseCookie token;
  private String type = "Bearer";
  private String id;
  private String username;
  private String email;
  private String address;
  private String city;
  private String state;
  private String zip;
  private List<String> roles;

  public UserInfoResponse(ResponseCookie accessToken, String id, String username, String email, String address,
      String city,
      String state,
      String zip, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.email = email;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;

    this.roles = roles;
  }

  public String getAccessToken() {
    return token.toString();
  }

  public void setAccessToken(ResponseCookie accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  public List<String> getRoles() {
    return roles;
  }
}
