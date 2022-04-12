package configuration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class YamlModel {

    @Getter
    @Setter
    @JsonProperty
    private String testedBrowser;

    @Getter
    @Setter
    @JsonProperty
    private String testedDataSet;

    @Setter
    @JsonProperty
    @JsonAnyGetter
    private HashMap<String, TestDataModel> testData;

    public YamlModel() {
    }

    public YamlModel(String testedBrowser, String testedDataSet, HashMap<String, TestDataModel> testData) {
        this.testedBrowser = testedBrowser;
        this.testedDataSet = testedDataSet;
        this.testData = testData;
    }

    public HashMap<String, TestDataModel> getTestData() {
        return testData;
    }
}
