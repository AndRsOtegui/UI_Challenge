package Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogTextFormatter extends Formatter {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        builder.append("[")
                .append(dateFormat.format(new Date(record.getMillis())))
                .append("] [")
                .append(record.getLevel())
                .append("] [")
                .append(record.getLoggerName())
                .append(".")
                .append(record.getSourceMethodName())
                .append("] - ")
                .append(record.getMessage())
                .append("\n");
        return builder.toString();
    }
}
