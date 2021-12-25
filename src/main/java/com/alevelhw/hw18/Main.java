package com.alevelhw.hw18;

import com.alevelhw.hw18.model.Box;
import com.alevelhw.hw18.util.BoxFromResources;
import com.alevelhw.hw18.util.FilePreparation;

public class Main {
    public static void main(String[] args) {
        String fileNameXml = "xml/box.xml";
        BoxFromResources boxFromResourcesXml = new BoxFromResources();
        Box boxXml = boxFromResourcesXml.getBox(fileNameXml, FilePreparation.getStringFromFile(fileNameXml));
        System.out.println(boxXml);

        String fileNameJson = "json/box.json";
        BoxFromResources boxFromResourcesJson = new BoxFromResources();
        Box boxJson = boxFromResourcesJson.getBox(fileNameJson, FilePreparation.getStringFromFile(fileNameJson));
        System.out.println(boxJson);
    }
}
