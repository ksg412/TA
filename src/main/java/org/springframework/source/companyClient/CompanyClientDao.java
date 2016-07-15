package org.springframework.source.companyClient;

import org.springframework.source.common.annotation.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-07-16.
 */
@Mapper
public interface CompanyClientDao {
    List selectCompanyClientList(Map comandMap) throws SQLException;
    int selectCompanyClientCount(Map comandMap) throws SQLException;
    void updateCompanyClientDetail(CompanyClientVo companyClientVo) throws SQLException;
    void insertCompanyClientDetail(CompanyClientVo companyClientVo) throws SQLException;
    void insertCompanyClientDetailList(CompanyClientVo companyClientVo) throws SQLException;
    void deleteCompanyClientDetailList(CompanyClientVo companyClientVo) throws SQLException;
    List selectCompanyClientDetailList(Map commandMap) throws SQLException;
    int selectCompanyClientDetailCount(Map commandMap) throws SQLException;
    CompanyClientVo selectCompanyClientDetail(String ncId) throws SQLException;
}
