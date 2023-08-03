package com.bridgelabz.demo.controller;

import com.bridgelabz.demo.dto.MultipleDTO;
import com.bridgelabz.demo.dto.RequestWrapper;
import com.bridgelabz.demo.dto.ResponseDTO;
import com.bridgelabz.demo.dto.StudentDTO;
import com.bridgelabz.demo.model.MultipartData;
import com.bridgelabz.demo.model.Student;
import com.bridgelabz.demo.repository.StudentRepo;
import com.bridgelabz.demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/Student")
@Component

public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private MultipartData multipartData;

    /*@PostMapping("/add")
    public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody StudentDTO studentDTO) {
        ResponseDTO responseDto = new ResponseDTO("Json_Data added successfully", StudentService.addContact(studentDTO));
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }*/

    @PostMapping(value = "json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> JsonHandleRequest( @RequestBody StudentDTO studentDTO) {
        Student student =  studentService.jsonHandleRequest(studentDTO);
        ResponseDTO responseDTO = new ResponseDTO("JSON_Data Successfully", student);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/formData",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> FormDataHandleRequest(@RequestBody StudentDTO studentDTO) {
        Student student = studentService.FormDataHandleRequest(studentDTO);
        ResponseDTO responseDTO = new ResponseDTO("Form_Data Added Successfully", studentService.addContact(studentDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "xml", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> XmlHandleRequest( @RequestBody StudentDTO studentDTO) {
        Student student = studentService.XmlHandleRequest(studentDTO);
        ResponseDTO responseDTO = new ResponseDTO("Xml_Data Added Successfully", studentService.addContact(studentDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/multipartData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ResponseDTO> MultipartDataHandleRequest(@RequestParam MultipartData file) throws IOException {
        MultipartFile multipartFile;
        File fileAdded = studentService.MultipartDataHandleRequest(MultipartFile);
        ResponseDTO responseDTO = new ResponseDTO("Multipart_Data Added Successfully", studentService.fileAdded);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


      @PostMapping("/multiple")

    public ResponseEntity<ResponseDTO> handleMultipleRequests(@RequestBody RequestWrapper requestWrapper) {
        StudentDTO studentDTO = requestWrapper.getStudentDTO();
        MultipleDTO multipleDTO = requestWrapper.getMultipleDTO();

        // Call the service layer method to handle the requests.
        Student student = studentService.handleMultipleRequests(studentDTO, multipleDTO);

        // Assuming the service method returns some data, set it in the response.
        ResponseDTO responseDTO = new ResponseDTO("Multiple requests handled Successfully", student);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

   /* @PostMapping("/multiple-student")
    public ResponseEntity<String> handleMultipleAndStudent(@RequestBody Map<String, Object> request) {
        ObjectMapper objectMapper = new ObjectMapper();
        MultipleDTO multipleDTO = objectMapper.convertValue(request.get("Multiple"), MultipleDTO.class);
        StudentDTO studentDTO = objectMapper.convertValue(request.get("Student"), StudentDTO.class);

        // Now you have separate DTO objects for the Multiple and Student data.
        // Process the DTOs as needed.

        return ResponseEntity.ok("Data received successfully!");
    }*/







}
