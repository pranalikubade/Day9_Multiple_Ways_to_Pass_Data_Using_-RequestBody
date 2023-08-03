package com.bridgelabz.demo.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class StudentDTO {
    @NotBlank(message = "Name is required")
    public String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    public String email;

    //@NotEmpty(message = "Phone number is required")
    //@Pattern(regexp = "^(?:(?:\\\\+91)|(?:91)|(?:0))[7-9][0-9]{9}$", message = "Invalid phone number")
    public String phoneNumber;
    public String city;
    public String pin;
    public String state;


    public Object getAge() {
        return null;
    }

    public String getPosition() {
        return null;
    }
}
