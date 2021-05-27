package web.service.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import web.service.models.AppFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class AppService {

    private final String serviceRESTGenerate;
    private final String serviceRESTAnswer;

    public AppService(String serviceRESTGenerate, String serviceRESTAnswer) {
        this.serviceRESTGenerate = serviceRESTGenerate;
        this.serviceRESTAnswer = serviceRESTAnswer;
    }

    public void sendPOSTRequestToRESTService(AppFields paramAppFields) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL(serviceRESTGenerate).openConnection();

        try {
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(10000);
            connection.setDoOutput(true);
            connection.connect();
            writeBody(connection, paramAppFields);
            String result = readBody(connection);
            AppFileGenerationResponse response = new ObjectMapper().readValue(result, AppFileGenerationResponse.class);
            if (response.getCode() == 201) {
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("FileGenerationService is unavailable");
        } finally {
            if (connection != null)
                connection.disconnect();
        }
    }

    public int sendGETRequestToRESTService() throws IOException {
        int returnedCode = 0;
        HttpURLConnection connection = (HttpURLConnection) new URL(serviceRESTAnswer).openConnection();
        try {
            connection.setRequestMethod("GET");
            connection.connect();
            String result = readBody(connection);
            AppFileGenerationResponse response = new ObjectMapper().readValue(result, AppFileGenerationResponse.class);
            returnedCode = response.getCode();
        } catch (IOException e) {
            System.out.println("FileGenerationService is unavailable");
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return returnedCode;
    }

    private String readBody(HttpURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String result = reader.lines().collect(Collectors.joining("\r\n"));
        reader.close();
        return result;
    }

    private void writeBody(HttpURLConnection connection, AppFields paramAppFields) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        String jsonBody = new ObjectMapper().writeValueAsString(paramAppFields);
        writer.write(jsonBody);
        writer.close();
    }
}
