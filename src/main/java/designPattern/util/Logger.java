package designPattern.util;

import java.text.MessageFormat;

public class Logger {
    public void info(String format, Object... argArray) {
        System.out.println(MessageFormat.format(format, argArray));
    }
}
