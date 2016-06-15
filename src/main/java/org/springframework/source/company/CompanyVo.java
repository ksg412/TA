package org.springframework.source.company;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.source.common.BaseVo;
import org.springframework.source.common.annotation.NumberValid;

import javax.validation.constraints.Size;

/**
 * Created by sg on 2016-06-12.
 */
public class CompanyVo extends BaseVo {

    private String companyId;

    @NotEmpty
    private String type;

    @NotEmpty
    @Size(min = 0, max = 100)
    private String name;

    @NotEmpty
    @Size(min=2,max = 10)
    private String managerName;

    @NotEmpty
    @Size(min = 10, max = 10)
    @NumberValid
    private String companyNumber;

    @NotEmpty
    @Size(min = 10, max = 11)
    @NumberValid
    private String mobilePhoneNumber;

    @NotEmpty
    @Size(min = 10, max = 11)
    @NumberValid
    private String companyPhoneNumber;

    private String address;
    private String rm;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }
}
