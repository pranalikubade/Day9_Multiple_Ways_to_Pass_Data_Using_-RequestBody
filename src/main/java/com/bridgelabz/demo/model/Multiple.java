package com.bridgelabz.demo.model;

import com.bridgelabz.demo.dto.MultipleDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Multiple {

    private int id;
    private String name;
    private  int age;
    private String position;


    public Multiple(MultipleDTO multipleDTO) {
        this.updateMultiple(multipleDTO);
    }

    // Method to update the Multiple object using data from the MultipleDTO object.
    public void updateMultiple(MultipleDTO multipleDTO) {
        this.name = multipleDTO.getName();
        this.age = multipleDTO.getAge();
        this.position = multipleDTO.getPosition();
    }

}
