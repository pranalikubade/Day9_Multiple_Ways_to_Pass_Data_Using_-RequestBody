package com.bridgelabz.demo.service;

import com.bridgelabz.demo.dto.MultipleDTO;
import com.bridgelabz.demo.dto.StudentDTO;
import com.bridgelabz.demo.model.Multiple;
import com.bridgelabz.demo.model.Student;
import com.bridgelabz.demo.repository.MultipleRepo;
import com.bridgelabz.demo.repository.StudentRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Service
public class StudentService {
    public Multiple fileAdded;
    @Autowired
    private StudentRepo studentRepo;

@Autowired
private MultipleRepo multipleRepo;

    public  Student handleMultipleRequests(StudentDTO studentDTO, MultipleDTO multipleDTO) {
        if (studentDTO == null) {
            // Handle the error or return an appropriate response
            // For example, you can throw an exception or return a default Student object.
            throw new IllegalArgumentException("StudentDTO is null");
        }
        // Create a new Student instance using the data from the StudentDTO
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setPosition(studentDTO.getPosition());

        // Process the MultipleDTO data and update the Student object accordingly
        student.setPosition(multipleDTO.getPosition());

        // Perform any other processing or calculations needed based on the data.
        /*Student = StudentRepo.save(student);
        // Return the updated Student object
        return student;*/
        return studentRepo.save(student);
    }

    public Student jsonHandleRequest(StudentDTO studentDTO) {
        Student student = new Student(studentDTO);
        return studentRepo.save(student);
    }

    public Student FormDataHandleRequest(StudentDTO studentDTO) {
        Student studentData = new Student(studentDTO);
        return studentRepo.save(studentData);
    }

    public Student XmlHandleRequest(StudentDTO studentDTO) {
        Student student = new Student(studentDTO);
        return studentRepo.save(student);
    }

    public Student MultipartDataHandleRequest(MultipartFile  file) throws IOException {

        File file1;
        file1 = new File(file.getOriginalFilename(), Arrays.toString(file.getBytes()));
        return MultipleRepo.save(file1);
    }

    public Student addContact(StudentDTO studentDTO) {
        Student studentData = new Student(studentDTO);
        return studentRepo.save(studentData);
    }

    private final StudentRepo repository;



    public StudentService(StudentRepo  repository) {
        this.repository = repository;
    }

    public void someMethod() {
        Student entity = new Student();
        repository.save(entity); // This will work correctly
    }

//    public <data> data MultipartDataHandleRequest(data file) {
//
//        return file;
//    }
}