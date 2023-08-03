package com.bridgelabz.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name = "MultipartData_Table")
//@Component
public class MultipartData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private  String fName;
    @Lob
    @Column(length = 16777215)
    private byte[] fData;

    public MultipartData(String fName,byte[] fData){
        this.fName = fName;
        this.fData = fData;

    }


}
