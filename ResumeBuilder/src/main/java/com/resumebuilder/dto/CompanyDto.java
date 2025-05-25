package com.resumebuilder.dto;

import java.util.List;

public class CompanyDto {

    private String companyName;
    private String category;
    private String address;
    private List<String> phoneNumbers;
    private List<String> faxNumbers;
    private String companyUrl;

    public CompanyDto() {
    }

    public CompanyDto(String companyName, String category, String address, List<String> phoneNumbers, List<String> faxNumbers, String companyUrl) {
        this.companyName = companyName;
        this.category = category;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.faxNumbers = faxNumbers;
        this.companyUrl = companyUrl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<String> getFaxNumbers() {
        return faxNumbers;
    }

    public void setFaxNumbers(List<String> faxNumbers) {
        this.faxNumbers = faxNumbers;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "companyName='" + companyName + '\'' +
                ", category='" + category + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", faxNumbers=" + faxNumbers +
                ", companyUrl='" + companyUrl + '\'' +
                '}';
    }
}
