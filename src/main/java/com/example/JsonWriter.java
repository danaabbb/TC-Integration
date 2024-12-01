package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonWriter {
    public void writeToJson(EmailRequest emailRequest) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("emailRequest.json"), emailRequest);
    }
}
