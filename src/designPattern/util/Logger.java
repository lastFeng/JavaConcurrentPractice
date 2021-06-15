package designPattern.util;

import java.util.Formatter;

public class Logger {
    public void info(String format, Object... argArray) {
        System.out.println(String.format(format, argArray));
    }
}
