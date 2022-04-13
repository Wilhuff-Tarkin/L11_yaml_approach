package configuration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class YamlModel {

    @Getter
    @Setter
    @JsonProperty
    private String testedBrowser;

    @Getter
    @Setter
    @JsonProperty
    private String testedDataSet = "default";

    @Setter
    @JsonAnyGetter
    private HashMap<String, EnvironmentModel> testData;


    public YamlModel() {
    }

    public YamlModel(String testedBrowser, String testedDataSet, HashMap<String, EnvironmentModel> testData) {
        this.testedBrowser = testedBrowser;
        this.testedDataSet = testedDataSet;
        this.testData = testData;
    }

    public HashMap<String, EnvironmentModel> getAllTestData() {
        return testData;
    }

}
