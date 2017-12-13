package com.company;


import com.company.Patient.Patient;
import com.company.Service.MediHealthService;
import com.company.Service.ServiceType;

public class Main {

    public static void main(String[] args) {

        Patient dario = new Patient("Dario","Ghunney",66, 12321323 ,true);
        Patient sabrina = new Patient("Sabrina","Ghunney",22, 2321345,false);

        MediHealthService healthService = new MediHealthService();
        healthService.addPatient(dario);
        healthService.addPatient(sabrina);

        System.out.println(healthService.printBill(dario, ServiceType.VACCINE, 5));
        System.out.println(healthService.printBill(dario, ServiceType.BLOODTEST, 0));
        System.out.println(healthService.printBill(sabrina, ServiceType.VACCINE, 5));

    }
}
