package model;


import enums.DateOfBirth;
import lombok.Data;

@Data
public class RegistrationForm {

    private DateOfBirth dateOfBirth;

    private String firstNameCustomer;
    private String lastNameCustomer;
    private String email;
    private String password;

}
