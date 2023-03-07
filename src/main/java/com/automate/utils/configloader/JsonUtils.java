package com.automate.utils.configloader;

import com.automate.constants.FrameworkConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class JsonUtils {
    private static Map<String, String> map;
    private JsonUtils() {
    }

    public static String getValue(String key) throws IOException {

            return JsonPath.read(new File(FrameworkConstants.getConfigJsonPath()), key);

    }

    static void readJson(String jsonPath) throws IOException {

            map = new ObjectMapper().readValue(new File(jsonPath),
                    new TypeReference<HashMap<String, String>>() {
                    });

    }


    }



