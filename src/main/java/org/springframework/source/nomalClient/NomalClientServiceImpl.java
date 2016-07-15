package org.springframework.source.nomalClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-16.
 */
@Service
public class NomalClientServiceImpl implements NomalClientService{

    @Autowired
    private NomalClientDao nomalClientDao;

    @Override
    public List selectNomalClientList(Map commandMap) throws Exception {
        return nomalClientDao.selectNomalClientList(commandMap);
    }

    @Override
    public int selectNomalClientCount(Map commandMap) throws Exception {
        return nomalClientDao.selectNomalClientCount(commandMap);
    }

    @Override
    public void updateNomalClientDetail(NomalClientVo nomalClientVo) throws Exception {
        nomalClientDao.updateNomalClientDetail(nomalClientVo);
        nomalClientDao.deleteNomalClientDetailList(nomalClientVo);
        if(nomalClientVo.getInsertList().size() > 0){
            nomalClientDao.insertNomalClientDetailList(nomalClientVo);
        }
    }

    @Override
    public void insertNomalClientDetail(NomalClientVo nomalClientVo) throws Exception {
        nomalClientDao.insertNomalClientDetail(nomalClientVo);
        if(nomalClientVo.getInsertList().size() > 0){
            nomalClientDao.insertNomalClientDetailList(nomalClientVo);
        }
    }

    @Override
    public List selectNomalClientDetailList(Map commandMap) throws Exception {
        return nomalClientDao.selectNomalClientDetailList(commandMap);
    }

    @Override
    public int selectNomalClientDetailCount(Map commandMap) throws Exception {
        return nomalClientDao.selectNomalClientDetailCount(commandMap);
    }

    @Override
    public NomalClientVo selectNomalClientDetail(String ncId) throws Exception {
        return nomalClientDao.selectNomalClientDetail(ncId);
    }


}
