package org.springframework.source.companyClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-07-16.
 */
@Service
public class CompanyClientServiceImpl implements CompanyClientService{

    @Autowired
    private CompanyClientDao companyClientDao;

    @Override
    public List selectCompanyClientList(Map commandMap) throws Exception {
        return companyClientDao.selectCompanyClientList(commandMap);
    }

    @Override
    public int selectCompanyClientCount(Map commandMap) throws Exception {
        return companyClientDao.selectCompanyClientCount(commandMap);
    }

    @Override
    public void updateCompanyClientDetail(CompanyClientVo companyClientVo) throws Exception {
        companyClientDao.updateCompanyClientDetail(companyClientVo);
        companyClientDao.deleteCompanyClientDetailList(companyClientVo);
        if(companyClientVo.getInsertList().size() > 0){
            companyClientDao.insertCompanyClientDetailList(companyClientVo);
        }
    }

    @Override
    public void insertCompanyClientDetail(CompanyClientVo companyClientVo) throws Exception {
        companyClientDao.insertCompanyClientDetail(companyClientVo);
        if(companyClientVo.getInsertList().size() > 0){
            companyClientDao.insertCompanyClientDetailList(companyClientVo);
        }
    }

    @Override
    public List selectCompanyClientDetailList(Map commandMap) throws Exception {
        return companyClientDao.selectCompanyClientDetailList(commandMap);
    }

    @Override
    public int selectCompanyClientDetailCount(Map commandMap) throws Exception {
        return companyClientDao.selectCompanyClientDetailCount(commandMap);
    }

    @Override
    public CompanyClientVo selectCompanyClientDetail(String ncId) throws Exception {
        return companyClientDao.selectCompanyClientDetail(ncId);
    }
}
