package com.alevelhw.module3.util;

import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static String mapAsString(Map<?, ?> map) {
        return map.keySet()
                .stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining("\n", "", ""));
    }
}
