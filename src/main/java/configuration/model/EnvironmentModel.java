package configuration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class EnvironmentModel {

    private static final Logger log = LoggerFactory.getLogger(EnvironmentModel.class);

    @JsonAnyGetter
    @JsonAnySetter
    private HashMap<String, Object> testPropertiesMap = new HashMap<>();

    public EnvironmentModel() {
    }

    public EnvironmentModel(HashMap<String, Object> testPropertiesMap) {
        this.testPropertiesMap = testPropertiesMap;
    }

    public HashMap<String, Object> getTestPropertiesMap() {
        return testPropertiesMap;
    }

    public String returnValueAsString (String key) {
        if (testPropertiesMap.containsKey(key)) {
            return testPropertiesMap.get(key).toString();
        } else {
            log.error("No property stored under this key in current test environment.");
            return "NO VALUE UNDER SUCH KEY";
            //todo looks sus
            //todo przeniesc do handlera?
        }
    }
}
