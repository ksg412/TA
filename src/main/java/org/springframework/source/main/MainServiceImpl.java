package org.springframework.source.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sg on 2016-06-05.
 */
@Service
public class MainServiceImpl implements MainService{

    @Autowired
    MainDao mainDao;

    @Override
    public String test() throws Exception {
        return mainDao.test();
    }
}
