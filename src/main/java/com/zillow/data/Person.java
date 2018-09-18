package com.zillow.data;

import java.util.Date;

public class Person {
    private String ssn;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private Double heightIn;
    private Double weightLb;

    public Person(String ssn,
                  Date dateOfBirth,
                  String firstName,
                  String lastName,
                  Double heightIn,
                  Double weightLb) {
        this.ssn = ssn;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightIn = heightIn;
        this.weightLb = weightLb;

    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(final String ssn) {
        this.ssn = ssn;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Double getHeightIn() {
        return heightIn;
    }

    public void setHeightIn(final Double heightIn) {
        this.heightIn = heightIn;
    }

    public Double getWeightLb() {
        return weightLb;
    }

    public void setWeightLb(final Double weightLb) {
        this.weightLb = weightLb;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %s, %s, %f, %f]", ssn, firstName, lastName, dateOfBirth, heightIn, weightLb);
    }
}
