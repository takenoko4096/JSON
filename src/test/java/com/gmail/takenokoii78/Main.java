package com.gmail.takenokoii78;

import com.gmail.takenokoii78.json.JSONSerializer;
import com.gmail.takenokoii78.json.values.JSONArray;
import com.gmail.takenokoii78.json.values.JSONObject;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        final JSONObject object = new JSONObject();
        object.set("replace", false);
        object.set("values", JSONArray.valueOf(List.of(
            "foo:bar"
        )));

        System.out.println(JSONSerializer.serialize(object));
    }
}
