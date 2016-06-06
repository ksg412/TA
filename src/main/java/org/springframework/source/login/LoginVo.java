package org.springframework.source.login;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.source.common.BaseVo;

/**
 * Created by sg on 2016-06-06.
 */
public class LoginVo extends BaseVo{

    private String id;
    private String pw;
    private String pwCheck;
    private String name;
    private String sex;

    @NotEmpty(message = "{validator.required.input}")
    private String birthDate;

    @NotEmpty(message="{javax.validation.constraints.AssertFalse.message}")
    private String phoneNumber;
    private String email;
    private String useYn;


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

    public String getPwCheck() {
        return pwCheck;
    }

    public void setPwCheck(String pwCheck) {
        this.pwCheck = pwCheck;
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

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
