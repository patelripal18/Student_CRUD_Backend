package Student.CURD.Operation.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "Student")
@Getter
@Setter
@Validated
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name is  mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Column
   @NotBlank(message = "Email is mandatory")
    @Email(message = "Email Should be Valid")
    private String email;

    @NotBlank(message = "Phone Number is mandatory")
    private String phoneNo;

    @NotBlank(message = "StudentClass is mandatory")
    private String studentClass;

    @NotBlank(message = "Stream is mandatory")
    private String stream;

    @NotBlank(message = "Year is mandatory")
    private String year;


}
