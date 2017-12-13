package com.company.Test;

import com.company.Patient.Patient;
import org.junit.Assert;
import org.junit.Test;

public class PatientTest {

    @Test
    public void createPatientSetAndReturnFirstName(){

        // Given
        String name = "Drake";

        // When
        Patient drake = new Patient("","lee",22, 9001,false);
        drake.setFirstName(name);

        // Then
        Assert.assertTrue(drake.getFirstName().equals(name));

    }

    @Test
    public void createPatientSetAndReturnLastName(){

        //Given
        String name = "Lee";

        // When
        Patient drake = new Patient("Drake","",22, 2321345,false);
        drake.setLastName(name);

        // Then
        Assert.assertTrue(drake.getLastName().equals(name));

    }

    @Test
    public void createPatientSetAndReturnAge(){

        //Given
        int age = 32;

        // When
        Patient drake = new Patient("Drake","Lee",0, 1345,false);
        drake.setAge(age);

        // Then
        Assert.assertTrue(drake.getAge() == age);



    }

    @Test
    public void createPatientAndAddInsurance(){

        // When
        Patient drake = new Patient("Drake","Lee",45, 1575,false);
        drake.setMediHealthHealthinsured(true);

        // Then
        Assert.assertTrue(drake.isMediHealthHealthinsured());

    }

    @Test
    public void createPatientAndRemoveInsurance(){

        // When
        Patient drake = new Patient("Drake","Lee",45, 1575,true);
        drake.setMediHealthHealthinsured(false);

        // Then
        Assert.assertFalse(drake.isMediHealthHealthinsured());

    }

}
