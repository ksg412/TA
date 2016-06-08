package org.springframework.source.login;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.source.common.BaseVo;
import org.springframework.source.common.annotation.DateValid;
import org.springframework.source.common.annotation.IdValid;
import org.springframework.source.common.annotation.NumberValid;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by sg on 2016-06-06.
 */
public class LoginVo extends BaseVo{

    @NotEmpty
    @Size(min = 5, max = 10)
    @IdValid
    private String id;

    @NotEmpty
    @Size(min = 8, max = 20)
    private String pw;

    @NotEmpty
    @Size(min = 8, max = 20)
    private String pwCheck;

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
