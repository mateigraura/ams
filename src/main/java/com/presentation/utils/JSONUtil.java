package com.presentation.utils;

import com.presentation.config.LocalStorage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JSONUtil {

    public static String[] getDbConnectionFromSettings() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(getFilePath().toString())) {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

            JSONObject dbPayload = (JSONObject) jsonObject.get("db");

            return new String[]{
                    dbPayload.get("url").toString(),
                    dbPayload.get("username").toString(),
                    dbPayload.get("password").toString()
            };

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String getDataOriginFromSettings(String target) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(getFilePath().toString())) {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

            return ((JSONObject) jsonObject.get("dataOrigin")).get(target).toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private static Path getFilePath() {
        String jsonFile = LocalStorage.getInstance().get("env").toString();
        return Paths.get(PackagePath.get("presentation").toString(), "config", "settings", jsonFile);
    }
}
