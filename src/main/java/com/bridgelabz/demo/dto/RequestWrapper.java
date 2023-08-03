package com.bridgelabz.demo.dto;

import lombok.Data;

@Data
public class RequestWrapper {
    private StudentDTO studentDTO;
    private MultipleDTO multipleDTO;

    public RequestWrapper(StudentDTO studentDTO, MultipleDTO multipleDTO) {
        this.studentDTO = studentDTO;
        this.multipleDTO = multipleDTO;
    }
}
