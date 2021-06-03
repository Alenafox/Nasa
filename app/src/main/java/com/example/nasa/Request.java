package com.example.nasa;

public class Request {
    String search_text;

    public Request(String text) {
        this.search_text = text;
    }

    String api_key = "1BdYYDHWRiHJLmuB90pQtorNZWpDCkCdGp2lRK0v";

    public String formDataToString() {
        return "&api_key="+api_key;
    }

}
