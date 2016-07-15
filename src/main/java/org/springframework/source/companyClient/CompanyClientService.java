package org.springframework.source.companyClient;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-07-16.
 */
public interface CompanyClientService {

    List selectCompanyClientList(Map commandMap) throws Exception;
    int selectCompanyClientCount(Map commandMap) throws Exception;
    void updateCompanyClientDetail(CompanyClientVo companyClientVo) throws Exception;
    void insertCompanyClientDetail(CompanyClientVo companyClientVo) throws Exception;
    List selectCompanyClientDetailList(Map commandMap) throws Exception;
    int selectCompanyClientDetailCount(Map commandMap) throws Exception;
    CompanyClientVo selectCompanyClientDetail(String ncId) throws Exception;
}
