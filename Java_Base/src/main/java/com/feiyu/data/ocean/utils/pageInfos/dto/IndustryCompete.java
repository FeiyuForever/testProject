package com.feiyu.data.ocean.utils.pageInfos.dto;

/**
 * @Author xzhou.James
 * @Date 2020/2/19  10:52
 */
public class IndustryCompete {

    private String competeId;
    private String companyName;
    private String address;
    private String legalPerson;

    public IndustryCompete() {
    }

    public IndustryCompete(String competeId, String companyName, String address, String legalPerson) {
        this.competeId = competeId;
        this.companyName = companyName;
        this.address = address;
        this.legalPerson = legalPerson;
    }

    public String getCompeteId() {
        return competeId;
    }

    public void setCompeteId(String competeId) {
        this.competeId = competeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }
}
