package com.example;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlReportWriter {
    public void writeHtmlReport(EmailRequest emailRequest) throws IOException {
        File htmlFile = new File("emailReport.html");

        // Write the HTML content to the file
        try (FileWriter writer = new FileWriter(htmlFile)) {
            writer.write("<html><body>");
            writer.write("<h1>Email Report</h1>");
            writer.write("<p><strong>To:</strong> " + emailRequest.getTo() + "</p>");
            writer.write("<p><strong>Subject:</strong> " + emailRequest.getSubject() + "</p>");
            writer.write("<p><strong>Body:</strong> " + emailRequest.getBody() + "</p>");
            writer.write("</body></html>");
        }

        // Open the file in the default web browser
        openInBrowser(htmlFile);
    }

    private void openInBrowser(File file) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) {
                    desktop.browse(file.toURI());
                    System.out.println("HTML report opened in the default browser.");
                } else {
                    System.err.println("File does not exist: " + file.getAbsolutePath());
                }
            } else {
                System.err.println("Desktop API is not supported on this system.");
            }
        } catch (IOException e) {
            System.err.println("Failed to open the HTML report in the browser: " + e.getMessage());
        }
    }
}
