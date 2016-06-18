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
}
