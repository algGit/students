package com.uniquex.students.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradedStudentTest {

    @Test
    public void createGradedStudent() {
        GradedStudent student = new GradedStudent("Test", 10.0);
        assertEquals("Test", student.name());
        assertEquals(10, student.grade());
    }
}