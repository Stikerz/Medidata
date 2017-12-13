package com.company.Test;

import com.company.Service.ServiceType;
import org.junit.Assert;
import org.junit.Test;

public class ServiceTypeTest {


    @Test //  Diagnosis Cost:  £60
    public void createServiceTypeDiagnosisAndGetCost(){

        // Given
        ServiceType diagnosis =  ServiceType.DIAGNOSIS;

        // Then
        Assert.assertEquals(60.00, diagnosis.getCost(), 0);

    }

    @Test //  Diagnosis Service Name:  DIAGNOSIS
    public void createServiceTypeDiagnosisAndGetName(){

        // Given
        ServiceType diagnosis =  ServiceType.DIAGNOSIS;

        // Then
        Assert.assertEquals("DIAGNOSIS", diagnosis.getServiceName());

    }

    @Test //  Xray Cost:  £150
    public void createServiceTypeXrayAndGetCost(){

        // Given
        ServiceType xray =  ServiceType.XRAY;

        // Then
        Assert.assertEquals(150.00, xray.getCost(), 0);

    }

    @Test //  XRAY Service Name:  XRAY
    public void createServiceTypeXrayAndGetName(){

        // Given
        ServiceType xray =  ServiceType.XRAY;

        // Then
        Assert.assertEquals("XRAY", xray.getServiceName());

    }

    @Test //  Bloodtest Cost:  £78
    public void createServiceTypeBloodtestAndGetCost(){

        // Given
        ServiceType vaccine =  ServiceType.BLOODTEST;

        // Then
        Assert.assertEquals(78.00, vaccine.getCost(), 0);

    }

    @Test //  Bloodtest Service Name:  BLOODTEST
    public void createServiceTypeBloodtestAndGetName(){

        // Given
        ServiceType bloodtest =  ServiceType.BLOODTEST;

        // Then
        Assert.assertEquals("BLOODTEST", bloodtest.getServiceName());

    }

    @Test //  ECG Cost:  £200.40
    public void createServiceTypeECGAndGetCost(){

        // Given
        ServiceType vaccine =  ServiceType.ECG;

        // Then
        Assert.assertEquals(200.40, vaccine.getCost(), 0);

    }

    @Test //  ECG Service Name:  ECG
    public void createServiceTypeECGAndGetName(){

        // Given
        ServiceType ecg =  ServiceType.ECG;

        // Then
        Assert.assertEquals("ECG", ecg.getServiceName());

    }

    @Test //  Vaccine Cost:  £27.50
    public void createServiceTypeVaccineAndGetCost(){

        // Given
        ServiceType vaccine =  ServiceType.VACCINE;

        // Then
        Assert.assertEquals(27.50, vaccine.getCost(), 0);

    }

    @Test //  Vaccine Service Name:  VACCINE
    public void createServiceTypeVaccineAndGetName(){

        // Given
        ServiceType vaccine =  ServiceType.VACCINE;

        // Then
        Assert.assertEquals("VACCINE", vaccine.getServiceName());

    }



}
