package ru.hogwarts.school.repositories;

import org.apache.coyote.ajp.AjpAprProtocol;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
