package starter.templates;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static java.util.stream.Collectors.toMap;

public class FieldValues {
    public static Map<String, String> in(String propertiesFile) throws IOException {
        Properties properties = new Properties();
        properties.load(FieldValues.class.getResourceAsStream("/" + propertiesFile));
        return properties.entrySet()
                .stream()
                .collect(toMap(entry -> entry.getKey().toString(),
                               entry -> entry.getValue().toString()));
    }
}
