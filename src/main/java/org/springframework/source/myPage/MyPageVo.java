package org.springframework.source.myPage;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.source.common.BaseVo;
import org.springframework.source.common.annotation.DateValid;
import org.springframework.source.common.annotation.EmptySizeValid;
import org.springframework.source.common.annotation.NumberValid;

import javax.validation.constraints.Size;

/**
 * Created by sg on 2016-06-12.
 */
public class MyPageVo extends BaseVo{

    private String id;
    private String pw;

    @EmptySizeValid(min = 8, max = 20)
    private String updatePw;

    @EmptySizeValid(min = 8, max = 20)
    private String updatePwCheck;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String name;

    @NotEmpty
    private String sex;

    @NotEmpty
    @DateValid
    private String birthDate;

    @NotEmpty
    @Size(min = 10, max = 11)
    @NumberValid
    private String phoneNumber;

    @NotEmpty
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUpdatePw() {
        return updatePw;
    }

    public void setUpdatePw(String updatePw) {
        this.updatePw = updatePw;
    }

    public String getUpdatePwCheck() {
        return updatePwCheck;
    }

    public void setUpdatePwCheck(String updatePwCheck) {
        this.updatePwCheck = updatePwCheck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
}
