package org.springframework.source.companyClient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.source.common.BaseVo;
import org.springframework.source.common.annotation.DateValid;
import org.springframework.source.common.annotation.NumberValid;

import javax.validation.constraints.Size;

/**
 * Created by sg on 2016-07-16.
 */
public class CompanyClientVo extends BaseVo {

    private String ccId;

    @NotEmpty
    private String companyId;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String name;

    @NotEmpty
    @DateValid
    private String birthDate;

    @NotEmpty
    @Size(min = 10, max = 11)
    @NumberValid
    private String phoneNumber;

    @NotEmpty
    private String email;

    private String address;
    private String rm;

    public String getCcId() {
        return ccId;
    }

    public void setCcId(String ccId) {
        this.ccId = ccId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
