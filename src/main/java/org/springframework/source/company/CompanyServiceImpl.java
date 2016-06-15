package org.springframework.source.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-12.
 */
@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyDao companyDao;


    @Override
    public void insertCompanyDetail(CompanyVo companyVo) throws Exception{
        companyDao.insertCompanyDetail(companyVo);
    }

    @Override
    public void updateCompanyDetail(CompanyVo companyVo) throws Exception{
        companyDao.updateCompanyDetail(companyVo);
    }

    @Override
    public List selectCompanyList(Map commandMap) throws Exception {
        return companyDao.selectCompanyList(commandMap);
    }

    @Override
    public int selectCompanyCount(Map commandMap) throws Exception {
        return companyDao.selectCompanyCount(commandMap);
    }
}
