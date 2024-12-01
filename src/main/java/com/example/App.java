package com.example;

 import java.io.IOException;
 
 public class App {
     public static void main(String[] args) {
         // Create a sample EmailRequest object
         EmailRequest request = new EmailRequest("test@example.com", "Hello", "This is a test email.");
 
         // Create a JsonWriter object to write the EmailRequest to a file
         JsonWriter writer = new JsonWriter();
 
         try {
             // Write EmailRequest object to JSON
             writer.writeToJson(request);
 
             // Read the JSON back into an EmailRequest object
             JsonReader reader = new JsonReader();
             EmailRequest readRequest = reader.readFromJson();
 
             // Print all fields of the deserialized EmailRequest object
             System.out.println("Email Details:");
             System.out.println("To: " + readRequest.getTo());
             System.out.println("Subject: " + readRequest.getSubject());
             System.out.println("Body: " + readRequest.getBody());


            // Generate and open the HTML report
            HtmlReportWriter htmlReportWriter = new HtmlReportWriter();
            htmlReportWriter.writeHtmlReport(readRequest);

         } catch (IOException e) {
             // Handle any errors that occur during the read/write process
             e.printStackTrace();
         }
     }
 }
 