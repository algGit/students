package com.uniquex.students.domain.entity;


import com.uniquex.students.domain.entity.port.Student;

public record GradedStudent(String name, Double grade) implements Student {

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
}
