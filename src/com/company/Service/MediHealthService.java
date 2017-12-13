package com.company.Service;

import com.company.Patient.Patient;
import com.company.Service.ServiceType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class MediHealthService {


    private List<Patient> patients;

    public MediHealthService() {
        patients = new ArrayList<Patient>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(long patientId) {
        patients.removeIf(patient -> patient.getId() == patientId);
    }

    public Optional<Patient> getPatient(long patientId) {
        return patients
                .stream()
                .findFirst()
                .filter(patient -> patient.getId() == patientId);
    }

    public int registeredPatientsNum(){
        return patients.size();
    }


    private double getAgeDiscountPercentage(Patient patient) {
        int age = patient.getAge();


        if (age < 5) {
            return 0.40;
        } else if (age >= 65 && age <= 70) {
            return 0.60;
        } else if (age > 70) {
            return 0.90;
        } else {
            return 0;
        }


    }

    public double calculateCost(Patient patient, ServiceType serviceType, int vaccinationsNum) {

        double service_cost = serviceType.getCost();
        String service_name = serviceType.getServiceName();
        double age_discount_percentage = getAgeDiscountPercentage(patient);
        double discount = 0;

        if (service_name.equals("VACCINE")) {
            service_cost +=  15 * vaccinationsNum;
        }

        if (age_discount_percentage != 0) {
            discount = age_discount_percentage * service_cost;
        }

        if (service_name.equals("BLOODTEST") && patient.isMediHealthHealthinsured()) {
            discount +=  0.15 * service_cost;
        }

        discount = BigDecimal.valueOf(discount).setScale(2, RoundingMode.HALF_UP).doubleValue();

        double total = service_cost - discount;

        return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP).doubleValue();


    }

    public String printBill(Patient patient, ServiceType serviceType, int vaccinationsNum) {
        if (serviceType.getServiceName().equals("VACCCINE") && vaccinationsNum <= 0) {
            throw new IllegalArgumentException(vaccinationsNum + " is not a valid vaccine number ");
        }

        String cost = String.format("%.2f", calculateCost(patient, serviceType, vaccinationsNum));

        return "MediHealth Private Medical Health Centre\n\n" +
                "First name:\t" + patient.getFirstName() +
                "\nLast name:\t" + patient.getLastName() +
                "\nAge:\t" + patient.getAge() +
                "\nService:\t" + serviceType.getServiceName() +
                "\nCost:\t£" + cost;
    }


}
