package org.springframework.source.common.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-11.
 */
@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    private CommonDao commonDao;

    @Override
    public List selectComboboxData(Map commandMap) throws Exception {
        return commonDao.selectComboboxData(commandMap);
    }

    @Override
    public String getCurrentPassword(String id) throws Exception {
        return commonDao.getCurrentPassword(id);
    }
}
