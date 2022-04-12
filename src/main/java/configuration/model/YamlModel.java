package configuration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import configuration.model.TestDataModel;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class YamlModel {

    @Getter
    @Setter
    @JsonProperty
    private String defaultBrowser;

    @Getter
    @Setter
    @JsonProperty
    private String defaultEnvironment;

    @Setter
    @JsonProperty
    @JsonAnyGetter
    private HashMap<String, TestDataModel> testData;

    public YamlModel() {
    }

    public YamlModel(String defaultBrowser, String defaultEnvironment, HashMap<String, TestDataModel> testData) {
        this.defaultBrowser = defaultBrowser;
        this.defaultEnvironment = defaultEnvironment;
        this.testData = testData;

    }

    public HashMap<String, TestDataModel> getTestData() {
        return testData;
    }

    @Override
    public String toString() {
        return "YamlModel{" +
                "defaultBrowser='" + defaultBrowser + '\'' +
                ", defaultEnvironment='" + defaultEnvironment + '\'' +
                ", testData=" + testData +
                '}';
    }
}
