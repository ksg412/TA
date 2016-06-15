package org.springframework.source.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by sg on 2016-06-15.
 */
@Component
public class MessageUtil {
    @Autowired
    private MessageSource messageSource;

    public String returnMsg(String msgCode){
        return messageSource.getMessage(msgCode,null, Locale.getDefault());
    }
}
