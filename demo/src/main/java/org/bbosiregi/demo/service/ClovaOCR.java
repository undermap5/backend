package org.bbosiregi.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class ClovaOCR {
    public static String SECRET = "SGdseEt4QUhDWndXSkRPZUtBTmFBR2VsSmRja0RCSks=";
    public static String API_URL = "https://clovachatbot.ncloud.com/api/chatbot/messenger/v1/15371/47fbb556ef8b4aec3e946defeaad20127f637af674fc84b2faa38e191648278b";

    public String execute(ImageParsingRequest request) {
        try {
            if (request.getSelectedOption() == null) {
                return firstQuestion();
            } else if (request.getFollowUpQuestion() == null) {
                return followUpQuestion(request.getSelectedOption());
            } else {
                return improvementQuestion();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return "Error: " + exception.getMessage();
        }
    }

    private String firstQuestion() {
        JSONObject response = new JSONObject();
        response.put("question", "undermap을 통해 어떤 편의시설을 이용하셨나요?");
        response.put("options", new JSONArray().put("엘리베이터").put("장애인 화장실").put("휠체어 리프트"));
        return response.toString();
    }

    private String followUpQuestion(String selectedOption) {
        JSONObject response = new JSONObject();
        response.put("question", selectedOption + "을(를) 이용하며 불편했던 점을 선택하여 주세요.");
        response.put("options", new JSONArray().put("편의시설까지의 거리").put("길 상태").put("편의시설의 상태"));
        return response.toString();
    }

    private String improvementQuestion() {
        JSONObject response = new JSONObject();
        response.put("question", "가/이 앞으로 개선되었으면 하는 방향을 말씀해주세요!");
        response.put("options", new JSONArray().put("시설개선").put("더 직관적인 안내"));
        return response.toString();
    }

    private HttpURLConnection createRequestHeader(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setReadTimeout(5000);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("X-OCR-SECRET", SECRET);
        return connection;
    }

    private void createRequestBody(HttpURLConnection connection, ImageParsingRequest request) throws IOException {
        JSONObject image = new JSONObject();
        image.put("format", "PNG");
        image.put("name", "requestImage");
        image.put("url", request.getUrl());

        JSONArray images = new JSONArray();
        images.put(image);

        JSONObject requestObject = new JSONObject();
        requestObject.put("version", "V2");
        requestObject.put("requestId", UUID.randomUUID().toString());
        requestObject.put("timestamp", System.currentTimeMillis());
        requestObject.put("lang", "ko");
        requestObject.put("resultType", "string");
        requestObject.put("images", images);
        requestObject.put("question", request.getQuestion());
        requestObject.put("options", new JSONArray(request.getOptions()));

        connection.connect();
        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.write(requestObject.toString().getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    private BufferedReader checkResponse(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        BufferedReader reader;

        if (responseCode == 200) {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8));
        }
        return reader;
    }

    private StringBuilder getResponseData(HttpURLConnection connection) throws IOException {
        BufferedReader reader = checkResponse(connection);
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response;
    }

    private StringBuilder parseResponseData(StringBuilder response) throws Exception {
        JSONObject parsed = new JSONObject(response.toString());
        JSONArray parsedImages = parsed.getJSONArray("images");
        StringBuilder result = new StringBuilder();

        if (parsedImages != null) {
            JSONObject parsedImage = parsedImages.getJSONObject(0);
            JSONArray parsedTexts = parsedImage.getJSONArray("fields");

            for (int i = 0; i < parsedTexts.length(); i++) {
                JSONObject current = parsedTexts.getJSONObject(i);
                result.append(current.getString("inferText")).append(" ");
            }
        }
        return result;
    }
}

//package org.bbosiregi.demo.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.util.StopWatch;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.util.UUID;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//@Service
//public class ClovaOCR {
//    public static String SECRET = "SGdseEt4QUhDWndXSkRPZUtBTmFBR2VsSmRja0RCSks=";
//    public static String API_URL = "https://clovachatbot.ncloud.com/api/chatbot/messenger/v1/15371/47fbb556ef8b4aec3e946defeaad20127f637af674fc84b2faa38e191648278b";
//
//    public String execute(ImageParsingRequest request) {
//        try {
//            if (request.getSelectedOption() == null) {
//                return firstQuestion();
//            } else if (request.getFollowUpQuestion() == null) {
//                return followUpQuestion(request.getSelectedOption());
//            } else {
//                return improvementQuestion();
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//
//        return null;
//    }
//
//    private String firstQuestion() {
//        JSONObject response = new JSONObject();
//        response.put("question", "undermap을 통해 어떤 편의시설을 이용하셨나요?");
//        response.put("options", new JSONArray().put("엘리베이터").put("장애인 화장실").put("휠체어 리프트"));
//        return response.toString();
//    }
//
//    private String followUpQuestion(String selectedOption) {
//        JSONObject response = new JSONObject();
//        response.put("question", selectedOption + "을(를) 이용하며 불편했던 점을 선택하여 주세요.");
//        response.put("options", new JSONArray().put("편의시설까지의 거리").put("길 상태").put("편의시설의 상태"));
//        return response.toString();
//    }
//
//    private String improvementQuestion() {
//        JSONObject response = new JSONObject();
//        response.put("question", "가/이 앞으로 개선되었으면 하는 방향을 말씀해주세요!");
//        response.put("options", new JSONArray().put("시설개선").put("더 직관적인 안내"));
//        return response.toString();
//    }
//
//    private HttpURLConnection createRequestHeader(URL url) throws IOException {
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setUseCaches(false);
//        connection.setDoInput(true);
//        connection.setDoOutput(true);
//        connection.setReadTimeout(5000);
//        connection.setRequestMethod("POST");
//        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//        connection.setRequestProperty("X-OCR-SECRET", SECRET);
//        return connection;
//    }
//
//    private void createRequestBody(HttpURLConnection connection, ImageParsingRequest request) throws IOException {
//        JSONObject image = new JSONObject();
//        image.put("format", "PNG");
//        image.put("name", "requestImage");
//        image.put("url", request.getUrl());
//
//        JSONArray images = new JSONArray();
//        images.put(image);
//
//        JSONObject requestObject = new JSONObject();
//        requestObject.put("version", "V2");
//        requestObject.put("requestId", UUID.randomUUID().toString());
//        requestObject.put("timestamp", System.currentTimeMillis());
//        requestObject.put("lang", "ko");
//        requestObject.put("resultType", "string");
//        requestObject.put("images", images);
//        requestObject.put("question", request.getQuestion());
//        requestObject.put("options", new JSONArray(request.getOptions()));
//
//        connection.connect();
//        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
//        outputStream.write(requestObject.toString().getBytes(StandardCharsets.UTF_8));
//        outputStream.flush();
//        outputStream.close();
//    }
//
//    private BufferedReader checkResponse(HttpURLConnection connection) throws IOException {
//        int responseCode = connection.getResponseCode();
//        BufferedReader reader;
//
//        if (responseCode == 200) {
//            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),StandardCharsets.UTF_8));
//        } else {
//            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream(),StandardCharsets.UTF_8));
//        }
//        return reader;
//    }
//
//    private StringBuilder getResponseData(HttpURLConnection connection) throws IOException {
//        BufferedReader reader = checkResponse(connection);
//        String line;
//        StringBuilder response = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            response.append(line);
//        }
//        reader.close();
//        return response;
//    }
//
//    private StringBuilder parseResponseData(StringBuilder response) throws Exception {
//        JSONObject parsed = new JSONObject(response.toString());
//        JSONArray parsedImages = parsed.getJSONArray("images");
//        StringBuilder result = new StringBuilder();
//
//        if (parsedImages != null) {
//            JSONObject parsedImage = parsedImages.getJSONObject(0);
//            JSONArray parsedTexts = parsedImage.getJSONArray("fields");
//
//            for (int i = 0; i < parsedTexts.length(); i++) {
//                JSONObject current = parsedTexts.getJSONObject(i);
//                result.append(current.getString("inferText")).append(" ");
//            }
//        }
//        return result;
//    }
//}