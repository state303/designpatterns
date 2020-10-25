package io.dsub.structural.bridge.example2;

import java.util.List;

public class PrintFormatter implements Formatter {
    @Override
    public String format(String header, List<Detail> details) {
        StringBuilder sb = new StringBuilder();

        sb.append(header);
        sb.append("\n");

        for (Detail detail : details) {
            sb.append(detail.getLabel());
            sb.append(":");
            sb.append(detail.getValue());
            sb.append("\n");
        }

        return sb.toString();
    }
}
