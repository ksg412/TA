package org.springframework.source.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sg on 2016-06-12.
 */
@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyDao companyDao;


}
