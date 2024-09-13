package Student.CURD.Operation.Repository;



import Student.CURD.Operation.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

//    List<Student> findAllByStudentIdIn(List<String> id);

    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
    List<Student> findByLastNameContainingIgnoreCase(String lastName);
    List<Student> findByEmailContainingIgnoreCase(String email);
    List<Student> findByPhoneNoContainingIgnoreCase(String phoneNo);
    List<Student> findByStudentClassContainingIgnoreCase(String studentClass);
    List<Student> findByStreamContainingIgnoreCase(String stream);
    List<Student> findByYearContainingIgnoreCase(String year);

}

