package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //makes this class to serve rest endpoints
@RequestMapping(path = "api/v1/student") //the endpoint for this path
public class StudentController {
    @Autowired
    StudentService studentService;

//    @GetMapping
//    public List<Student> getStudents(){
//        return studentService.getStudents();
//    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<List<Student>>(studentService.getStudents(), HttpStatus.OK);
    }

//    @PostMapping
//    public void registerNewStudent(@RequestBody Student student){ //we take the body and map it to a student
//        studentService.addNewStudent(student);
//    }
    @PostMapping()
    public ResponseEntity registerNewStudent(@RequestBody Student student) {
        try {
            studentService.addNewStudent(student);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{studentId}")
//    public void deleteStudent(@PathVariable("studentId") Long studentId){
//        studentService.deleteStudent(studentId);
//    }
    public ResponseEntity deleteStudent(@PathVariable Long studentId) {
        try {
            studentService.deleteStudent(studentId);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity updateStudent(
        @PathVariable Long studentId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email
    ){

        try {
            studentService.updateStudent(studentId, name, email);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
