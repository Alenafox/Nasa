package com.example.nasa;

public class Request {
    String search_text;
    String api_key = "1BdYYDHWRiHJLmuB90pQtorNZWpDCkCdGp2lRK0v";

    public Request(String text) {
        this.search_text = text;
    }

    public String formDataToString() {
        return "api_key=" + api_key;
    }

}
