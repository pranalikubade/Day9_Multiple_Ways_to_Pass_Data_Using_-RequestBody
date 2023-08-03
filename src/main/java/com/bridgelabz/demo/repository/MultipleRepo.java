package com.bridgelabz.demo.repository;

import com.bridgelabz.demo.model.Multiple;
import com.bridgelabz.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;

public interface MultipleRepo extends JpaRepository<Multiple,Long> {


    static Student save(File file1) {
        return null;
    }
}


