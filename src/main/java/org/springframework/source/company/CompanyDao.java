package org.springframework.source.company;

import org.springframework.source.common.annotation.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-12.
 */
@Mapper
public interface CompanyDao {
    void insertCompanyDetail(CompanyVo companyVo) throws SQLException;
    void updateCompanyDetail(CompanyVo companyVo) throws SQLException;
    List selectCompanyList(Map commandMap) throws SQLException;
    int selectCompanyCount(Map commandMap) throws SQLException;
    CompanyVo selectCompanyDetail(String companyId) throws SQLException;
}
