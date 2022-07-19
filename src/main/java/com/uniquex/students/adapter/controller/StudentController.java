package com.uniquex.students.adapter.controller;

import com.uniquex.students.adapter.repository.InMemoryRepository;
import com.uniquex.students.domain.entity.port.Student;
import com.uniquex.students.usecase.StudentSorter;
import com.uniquex.students.usecase.port.StudentAPI;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toUnmodifiableList;

@RestController
public record StudentController(StudentSorter studentSorter, InMemoryRepository inMemoryRepository)
        implements StudentAPI {


    @PostMapping("/sort")
    public List<StudentDAO> sortStudentByAlgorithm(
            @RequestParam("algorithm") String sortAlgorithmName, @RequestBody List<StudentDAO> students) {
        List<Student> gradedStudents = students.stream()
                .map(StudentDAO::daosToGraded).collect(toUnmodifiableList());
        return  studentSorter.sortStudentsBy(sortAlgorithmName, gradedStudents).stream()
                .peek(inMemoryRepository::addStudent)
                .map(i -> new StudentDAO(i.getName(), i.getGrade())).collect(Collectors.toList());
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return inMemoryRepository.getAllStudents();
    }
}
