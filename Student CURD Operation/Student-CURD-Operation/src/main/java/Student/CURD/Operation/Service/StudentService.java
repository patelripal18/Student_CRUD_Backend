    package Student.CURD.Operation.Service;

    import Student.CURD.Operation.Entity.Student;
    import Student.CURD.Operation.Repository.StudentRepository;
    import Student.CURD.Operation.filter.StudentFilter;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;
    import java.util.stream.Collectors;

    @Service
    public class StudentService {


        @Autowired
        private StudentRepository studentRepository;

        public List<Student> getAllStudent() {
            return studentRepository.findAll();
        }

        public Optional<Student> getstudentById(Long id) {
            return studentRepository.findById(id);
        }

        public Student createstudent(Student student) {

            return studentRepository.save(student);

        }
        public List<Student> filterStudent(StudentFilter filter) {
            List<Student> student = studentRepository.findAll();

            if (filter.getFirstName() != null) {
                student = student.stream()
                        .filter(e -> e.getFirstName().toLowerCase().contains(filter.getFirstName().toLowerCase()))
                        .collect(Collectors.toList());
            }
            if (filter.getLastName() != null) {
                student = student.stream()
                        .filter(e -> e.getLastName().toLowerCase().contains(filter.getLastName().toLowerCase()))
                        .collect(Collectors.toList());
            }
            if (filter.getEmail() != null) {
                student = student.stream()
                        .filter(e -> e.getEmail().toLowerCase().contains(filter.getEmail().toLowerCase()))
                        .collect(Collectors.toList());
            }
            if (filter.getPhoneNo() != null) {
                student = student.stream()
                        .filter(e -> e.getPhoneNo().toLowerCase().contains(filter.getPhoneNo().toLowerCase()))
                        .collect(Collectors.toList());
            }
            if (filter.getStudentClass() != null) {
                student = student.stream()
                        .filter(e -> e.getStudentClass().toLowerCase().contains(filter.getStudentClass().toLowerCase()))
                        .collect(Collectors.toList());
            }
            if (filter.getStream() != null) {
                student = student.stream()
                        .filter(e -> e.getStream().toLowerCase().contains(filter.getStream().toLowerCase()))
                        .collect(Collectors.toList());
            }
            if (filter.getYear() != null) {
                student = student.stream()
                        .filter(e -> e.getYear().toLowerCase().contains(filter.getYear().toLowerCase()))
                        .collect(Collectors.toList());
            }

            return student;
        }


        public Student updateStudent(Long id, Student studentDetails) {
            Optional<Student> optionalStudent = studentRepository.findById(id);
            if (optionalStudent.isPresent()) {
                Student student = optionalStudent.get();
                student.setFirstName(studentDetails.getFirstName());
                student.setLastName(studentDetails.getLastName());
                student.setEmail(studentDetails.getEmail());
                student.setPhoneNo(studentDetails.getPhoneNo());
                student.setStudentClass(studentDetails.getStudentClass());
                student.setStream(studentDetails.getStream());
                student.setYear(studentDetails.getYear());

                // Save the updated student entity to the database
                return studentRepository.save(student);
            } else {

                return null;
            }
        }


        public void deleteStudent(Long id) {
            studentRepository.deleteById(id);
        }


    }


