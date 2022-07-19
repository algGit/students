package com.uniquex.students.adapter.controller;

import com.uniquex.students.domain.entity.GradedStudent;
import com.uniquex.students.domain.entity.port.Student;

public record StudentDAO(String name, Double grade) implements Student {
    @Override
    public int compareTo(Student otherStudent) {
        return Double.compare(grade, otherStudent.getGrade());
    }

    @Override
    public Double getGrade() {
        return this.grade;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static GradedStudent daosToGraded(StudentDAO studentDAO) {
        return new GradedStudent(studentDAO.getName(), studentDAO.getGrade());
    }
}
