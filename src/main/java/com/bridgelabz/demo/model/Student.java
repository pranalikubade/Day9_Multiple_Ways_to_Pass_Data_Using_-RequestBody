package com.bridgelabz.demo.model;

import com.bridgelabz.demo.dto.StudentDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Student_Table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String state;
    private String city;
    private String pin;

    public Student(StudentDTO studentDTO) {

        this.updateContact(studentDTO);
    }

    public void updateContact(StudentDTO studentDTO) {
        this.name = studentDTO.name;
        this.email = studentDTO.email;
        this.phoneNumber = studentDTO.phoneNumber;
        this.state = studentDTO.state;
        this.city =studentDTO.city;
        this.pin = studentDTO.pin;
    }

    public void setPosition(String position) {
    }

    public void setAge(Object age) {
    }
}
