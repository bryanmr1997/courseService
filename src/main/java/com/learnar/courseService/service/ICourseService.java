package com.learnar.courseService.service;


import com.learnar.courseService.models.Courses;

import java.util.List;

public interface ICourseService {




    List<Courses> listarCourses();

    Courses registrarCourses(Courses body);

    Courses actualizar(Courses body, Long id);

    String eliminar(Long idCourses);
}
