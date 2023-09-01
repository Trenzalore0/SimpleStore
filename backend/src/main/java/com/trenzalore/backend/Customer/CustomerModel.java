package com.trenzalore.backend.Customer;

import java.sql.Timestamp;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;

  @Column(unique = true)
  private String email;

  private String password;

  @CreationTimestamp
  private Timestamp createdAt;

  @UpdateTimestamp
  private Timestamp updatedAt;

  public CustomerModel(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public CustomerModel setId(String id) {
    this.id = id;
    return this;
  }

  public String getId() {
    return id;
  }

  public CustomerModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public CustomerModel setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public CustomerModel setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public CustomerModel setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public CustomerModel setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } 
    if (!(o instanceof CustomerModel)) {
      return false;
    }
    CustomerModel customer = (CustomerModel) o;
    return Objects.equals(customer.id, this.id) &&
      Objects.equals(customer.name, this.name) &&
      Objects.equals(customer.email, this.email) &&
      Objects.equals(customer.password, this.password) &&
      Objects.equals(customer.createdAt, this.createdAt) &&
      Objects.equals(customer.updatedAt, this.updatedAt);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, password, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    return "CustomerModel { id = " + id 
      + ", name = " + name
      + ", email = " + email 
      + ", password = " + password 
      + ", createdAt = " + createdAt 
      + ", updatedAt = " + updatedAt + "}";
  }
}
