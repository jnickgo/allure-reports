package com.nipr.api;

public class Identity
{
    public String entityType;
    public String searchType;
    public String lastName;
    public String ssn;
    public String dob;

    public Identity(String entityType, String searchType, String lastName, String ssn)
    {
        this.entityType = entityType;
        this.searchType = searchType;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public Identity(String entityType, String searchType, String lastName, String ssn, String dob)
    {
        this.entityType = entityType;
        this.searchType = searchType;
        this.lastName = lastName;
        this.ssn = ssn;
        this.dob = dob;
    }


    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
