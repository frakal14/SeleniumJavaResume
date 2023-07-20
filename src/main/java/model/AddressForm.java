package model;

import enums.Country;
import enums.State;
import lombok.Data;

@Data
public class AddressForm {

    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String city;
    private State state;
    private String postalCode;
    private Country country;
    private String homePhone;
    private String mobilePhone;
    private String additionalInformation;
    private String addressAlias;



}
