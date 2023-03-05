package com.learnar.courseService.controller;


import com.learnar.courseService.models.Courses;
import com.learnar.courseService.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/course")
@RestController
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;



    @GetMapping("/listar")
    public ResponseEntity <List<Courses>> listarCursos() {
        List<Courses> list=courseService.listarCourses();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @GetMapping("/listar")
//    public List<Courses> listarCursos() {
//        return courseService.listarCourses();
//    }

    @PostMapping("/registrar")
    public Courses registrarCursos(@RequestBody Courses body) {
        return courseService.registrarCourses(body);
    }

    @PutMapping("/actualizar/{id}")
    public Courses actualizar(@RequestBody Courses body, @PathVariable("id") Long id) {
        return courseService.actualizar(body, id);
    }

    @DeleteMapping("/deshabilitar/{id}")
    public String deshabilitar(@PathVariable("id") Long id) {
        return courseService.eliminar(id);
    }

}

