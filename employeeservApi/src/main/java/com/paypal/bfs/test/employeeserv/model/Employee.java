//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.paypal.bfs.test.employeeserv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"id", "first_name", "last_name"})
@Data
@Table(name="employee")
@Entity
public class Employee {
    @JsonPropertyDescription("employee id")
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @JsonProperty("first_name")
    @JsonPropertyDescription("first name")
    @NotNull
    private String firstName;
    
    @JsonProperty("last_name")
    @JsonPropertyDescription("last name")
    @NotNull
    private String lastName;
    
    @JsonProperty("date_of_birth")
    @NotNull
    private String dob;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;
   
}
