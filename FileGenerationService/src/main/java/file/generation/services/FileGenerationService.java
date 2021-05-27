package file.generation.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import file.generation.dao.FileGenerationEventDAO;
import file.generation.misc.FileGenerationTextProcessing;
import file.generation.models.FileGenerationEvent;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

public class FileGenerationService {

    private final String serviceWebLink;

    public FileGenerationService(String serviceWebLink) {
        this.serviceWebLink = serviceWebLink;
    }

    public void sendFileToWebService(FileGenerationEvent event, FileGenerationEventDAO fileGenerationEventDAO) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL(serviceWebLink).openConnection();

        try {
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(10000);
            connection.setDoOutput(true);
            connection.connect();

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            String jsonBody = new ObjectMapper().writeValueAsString(event);
            writer.write(jsonBody);
            writer.close();

            int HttpResult = connection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                fileGenerationEventDAO.delete(event.getDateTime(), "events_ready");
                FileGenerationTextProcessing fileText = new FileGenerationTextProcessing();
                fileText.deleteTextFile(event);
            } else {
                connection.getResponseMessage();
            }
        } catch (IOException | SQLException e) {
            throw new FileGenerationExceptionHandler("Error sending the file to web service",
                    e.getCause(),
                    FileGenerationService.class,
                    connection.getRequestMethod());
        } finally {
            if (connection != null)
                connection.disconnect();
        }
    }
}
