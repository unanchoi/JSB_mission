package com.misson.mission3;


import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class GsonComponent {
    private final Gson gson;

    public GsonComponent() {
        this.gson = new Gson();
    }

    public getGson() {
        return this.gson;
    }
}
