package com.reobotnet.hexagonal.aplication.core.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessageUtil {

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");

    public static String getMessage(String key, Object... params) {
        String message = RESOURCE_BUNDLE.getString(key);
        return MessageFormat.format(message, params);
    }
}