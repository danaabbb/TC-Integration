package com.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonReader {
    public EmailRequest readFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("emailRequest.json"), EmailRequest.class);
    }
}
