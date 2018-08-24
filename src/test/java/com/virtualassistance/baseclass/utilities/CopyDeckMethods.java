package com.virtualassistance.baseclass.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;

public class CopyDeckMethods {

    PropertiesFile propertiesFile = new PropertiesFile();

    private static CopyDeckMethods instance = new CopyDeckMethods();

    private static Map<Object, Map<String,String>> copyDeckMap = new HashMap<>();

    public static CopyDeckMethods getInstance()
    {
        return instance;
    }

    public Map<Object,Map<String,String>> loadCopyDeck() throws IOException {
        if (copyDeckMap.isEmpty())
        {
            String fileText = readFileToString(new File("C:/Users/Anil Kumar/IdeaProjects/VirtualAssistanceDraft/DataSource/copydeck.json"));
            List<Map<String, String>> copydeckMapTemp = new Gson().fromJson(fileText, new TypeToken<List<Map<String, String>>>() {
            }.getType());

            for (Map<String, String> entry : copydeckMapTemp) {
                    Map<String, String> tempValueList = new HashMap<>();
                    tempValueList.put("en", entry.getOrDefault("en", "NoTextFr").toString());
                    tempValueList.put("fr", entry.getOrDefault("fr", "NoTextEn").toString());

                    copyDeckMap.put(entry.get("UniqueKey"), tempValueList);

                }
            //return copyDeckMap;

            }
            return copyDeckMap;
    }
}
