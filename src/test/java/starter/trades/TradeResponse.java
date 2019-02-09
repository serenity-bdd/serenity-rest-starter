package starter.trades;

import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class TradeResponse {
    public Map<String, String> returned() {
       return mapOfStringsFrom(SerenityRest.lastResponse().getBody().as(Map.class));
    }

    private Map<String,String> mapOfStringsFrom(Map<String, Object> map) {
        return map.entrySet()
                .stream()
                .collect(toMap(Map.Entry::getKey,
                        entry -> entry.getValue().toString()));
    }
}
