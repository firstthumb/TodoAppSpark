package com.ekocaman.todo.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Response;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    private final Gson gsonResponse = new GsonBuilder().registerTypeAdapter(Response.class, new ResponseTypeAdapter<Response>()).create();
    private final Gson gson = new Gson();

    @Override
    public String render(Object model) {
        if (model instanceof Response) {
            return gsonResponse.toJson(model);
        } else {
            return gson.toJson(model);
        }
    }
}