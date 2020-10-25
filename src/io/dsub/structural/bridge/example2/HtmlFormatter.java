package io.dsub.structural.bridge.example2;

import java.util.List;

public class HtmlFormatter implements Formatter {
    @Override
    public String format(String header, List<Detail> details) {
        StringBuilder sb = new StringBuilder();

        sb.append("<table>");
        sb.append("<th>");
        sb.append("<Classification>");
        sb.append("</th>");

        sb.append("<th>");
        sb.append(header);
        sb.append("</th>");

        for (Detail detail : details) {
            sb.append("<tr><td>");
            sb.append(detail.getLabel());
            sb.append("</td><td>");
            sb.append(detail.getValue());
            sb.append("</td></tr>");
        }

        sb.append("</table>");
        return sb.toString();
    }
}
