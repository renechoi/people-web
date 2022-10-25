package com.neutrio.peopledbweb.biz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue

    private Long id;
    @NotEmpty(message="First name can not be empty")
    private String firstName;

    @NotEmpty(message="Last name can not be empty")
    private String lastName;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @Email(message ="Email must be valid")
    @NotEmpty(message = "Email must not be empty")
    private String email;

    @DecimalMin(value="1000.00", message ="Salary must be at least 1000")
    @NotNull(message = "Salary must not be empty")
    private BigDecimal salary;


    public String getFormattedDOB(){
        return DateTimeFormatter.ofPattern("MMMM dd, yyyy").format(dob);
    }
}
