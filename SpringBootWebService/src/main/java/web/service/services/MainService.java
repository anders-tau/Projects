package web.service.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import web.service.models.Fields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
public class MainService {

    private final WebClient webClient;

    public MainService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://localhost:8080/generate").build();
    }

    public String message() {
        return "The service responded";
    }

    public void SendRequestToREST(String serverUrl, String host, String jsonobject, Fields paramFields) {

        StringBuilder sb = new StringBuilder();
        String http = serverUrl;
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(http);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(50000);
            urlConnection.setReadTimeout(50000);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Host", host);
            urlConnection.connect();
            //You Can also Create JSONObject here
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jsonobject);// here i sent the parameter
            out.close();
            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                //Log.e("new Test", "" + sb.toString());
                //return sb.toString();
            } else {
                //Log.e(" ", "" + urlConnection.getResponseMessage());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
//        } catch (ProtocolException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
        //return null;

        System.out.println(paramFields.getId());
        System.out.println(paramFields.getParam1());
        System.out.println(paramFields.getParam2());
        System.out.println(paramFields.getParam3());
        System.out.println(paramFields.getParam4());
        System.out.println(paramFields.getParam5());

    }

    public Mono<Fields> someRestCall(String name) {
        return this.webClient.get().uri("/{name}/details", name)
                .retrieve().bodyToMono(Fields.class);
    }
}

