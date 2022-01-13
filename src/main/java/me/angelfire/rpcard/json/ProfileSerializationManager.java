package me.angelfire.rpcard.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import me.angelfire.rpcard.Profile;

public class ProfileSerializationManager {


    private Gson gson;
    
    public ProfileSerializationManager() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
    }



    public String serialize(Profile profile) {
    	return this.gson.toJson(profile);
    }

    public Profile deserialize(String json) throws JsonSyntaxException {
    	return this.gson.fromJson(json, Profile.class);
    	
    }
}
