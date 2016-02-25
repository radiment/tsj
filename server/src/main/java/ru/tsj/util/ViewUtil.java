package ru.tsj.util;

import com.sun.jersey.api.view.Viewable;

import java.util.Map;

import static java.util.Collections.singletonMap;

public class ViewUtil {

    public static Object view(String template) {
        return new Viewable(template);
    }

    public static Object view(String template, Object value) {
        return new Viewable(template, singletonMap("val", value));
    }

    public static Object view(String template, Map<String, ?> values) {
        return new Viewable(template, values);
    }
}
