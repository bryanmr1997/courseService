package com.learnar.courseService.service;



import com.learnar.courseService.models.Courses;
import com.learnar.courseService.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public List<Courses> listarCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses registrarCourses(Courses body) {
        Courses nuevo=new Courses(body.getName(), body.getDescription(), "ENABLED");

        return courseRepository.save(nuevo);
    }

    @Override
    public Courses actualizar(Courses body, Long id) {

        Optional<Courses> courses=courseRepository.findById(id);
        if(courses.isPresent()){
            Courses coursesActualizado=courses.get();

            coursesActualizado.setName(body.getName());
            coursesActualizado.setDescription(body.getDescription());

            courseRepository.save(coursesActualizado);
        }
        return null;
    }

    @Override
    public String eliminar(Long idCourses) {

        Optional<Courses> encontrado=courseRepository.findById(idCourses);

        if(encontrado.isPresent()){

                Courses courseDisabled=encontrado.get();
                courseDisabled.setState("DISABLED");
                courseRepository.save(courseDisabled);
                return "Curso deshabilitado";
        }

        return "No se encontro el id";
    }
}
