package com.company.Test;

import com.company.Service.MediHealthService;
import com.company.Patient.Patient;
import com.company.Service.ServiceType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class HealthServiceTest {

    private MediHealthService healthService ;
    private ServiceType diagnosis;
    private ServiceType vaccine;
    private ServiceType bloodtest;
    private ServiceType ecg;
    private ServiceType xray;

    @Before
    public void setUp(){

        // Create test patient
        Patient dariojnr = new Patient("Dariojnr","Ghunney",2, 1345,true);

        // Create test health service
         healthService = new MediHealthService();

        // Add three patient to service
        healthService.addPatient(dariojnr);


        //Create All Service Types
        diagnosis =  ServiceType.DIAGNOSIS;
        vaccine =  ServiceType.VACCINE;
        bloodtest =  ServiceType.BLOODTEST;
        ecg =  ServiceType.ECG;
        xray =  ServiceType.XRAY;

    }

    @Test
    public void addPatient(){

        //Given
        Assert.assertEquals(1, healthService.registeredPatientsNum());
        Patient joel = new Patient("Joel","yardman",66, 12321323 ,true);

        //Then
        healthService.addPatient(joel);

        Assert.assertEquals(2, healthService.registeredPatientsNum());

    }

    @Test
    public void removePatient(){
        //Given
        Assert.assertEquals(1, healthService.registeredPatientsNum());

        //Then
        healthService.removePatient(1345);
        Assert.assertEquals(0, healthService.registeredPatientsNum());

    }

    @Test
    public void getPatient(){
        //Given
        Assert.assertEquals(1, healthService.registeredPatientsNum());
        Optional<Patient> matchingObject =  healthService.getPatient(1345);

        //Then
        Patient dariojnr = matchingObject.get();
        Assert.assertEquals("Dariojnr", dariojnr.getFirstName());
        Assert.assertEquals("Ghunney", dariojnr.getLastName());
        Assert.assertEquals(2, dariojnr.getAge());
        Assert.assertEquals(true, dariojnr.isMediHealthHealthinsured());

    }

    @Test
    public void calculateCostOfSeniorCitizenOver70WithDiagnosis(){
        Patient dario = new Patient("Dario","Ghunney",71, 12321323 ,true);
        healthService.addPatient(dario);

        double cost = healthService.calculateCost(dario,diagnosis,0);
        // 90% of £60 = 54
        // cost = £6
        Assert.assertEquals(6, cost, 0);

    }

    @Test
    public void calculateCostOfSeniorCitizenBetween65and70WithXray(){
        Patient sabrina = new Patient("Sabrina","Ghunney",66, 2321345,false);
        healthService.addPatient(sabrina);

        double cost = healthService.calculateCost(sabrina,xray,0);
        // 60% of £150 = 90
        // cost = £60
        Assert.assertEquals(60, cost, 0);

    }

    @Test
    public void calculateCostOfChildUnder5WithECG(){
        Patient sabrinajnr = new Patient("Sabrinajnr","Ghunney",2, 223045,false);
        healthService.addPatient(sabrinajnr);

        double cost = healthService.calculateCost(sabrinajnr,ecg,0);
        // 40% of £200.40 = 80.16
        // cost = £120.24
        Assert.assertEquals(120.24, cost, 0);

    }

    @Test
    public void calculateCostOfInsuredCostOfChildUnder5WithWithBloodTest(){
        Patient sabrinajnr = new Patient("Sabrinajnr","Ghunney",2, 223045,true);
        healthService.addPatient(sabrinajnr);

        double cost = healthService.calculateCost(sabrinajnr,bloodtest,0);
        // 40% of £78 = 31.2
        // 15% of £78 = 11.7
        // discount total = 42.9
        // cost = 35.1

        Assert.assertEquals(35.1, cost, 0);

    }

    @Test
    public void calculateCostOfPatientWith5Vaccines(){
        Patient james = new Patient("James","Mutinda",22, 2321345,true);
        healthService.addPatient(james);

        double cost = healthService.calculateCost(james,vaccine,5);
        // Vaccine service cost = £27.50
        // Vaccine cost £15 * 5 = £75
        // cost = 102.50

        Assert.assertEquals(102.50, cost, 0);

    }


}
