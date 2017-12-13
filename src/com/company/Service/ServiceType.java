package com.company.Service;

public enum ServiceType {
    DIAGNOSIS(60.00, "DIAGNOSIS"),
    XRAY(150.00, "XRAY"),
    BLOODTEST(78.00, "BLOODTEST"),
    ECG(200.40, "ECG"),
    VACCINE(27.50, "VACCINE");

    private final double cost;
    private final String serviceName;

    ServiceType(double cost, String serviceName){
        this.cost = cost;
        this.serviceName = serviceName;
    }

    public double getCost() {
        return cost;
    }

    public String getServiceName(){
        return serviceName;
    }
}
