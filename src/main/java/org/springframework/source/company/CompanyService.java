package org.springframework.source.company;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-12.
 */
public interface CompanyService {
    void insertCompanyDetail(CompanyVo companyVo) throws Exception;
    void updateCompanyDetail(CompanyVo companyVo) throws Exception;
    List selectCompanyList(Map commandMap) throws Exception;
    int selectCompanyCount(Map commandMap) throws Exception;

}
