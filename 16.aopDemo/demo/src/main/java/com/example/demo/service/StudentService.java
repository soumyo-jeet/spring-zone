package com.example.demo.service;

import com.example.demo.annotation.TrackExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "save student"
    )
    public String createStudent() {
        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {}

        System.out.println("student saved");
        return "student saved";
    }
}
