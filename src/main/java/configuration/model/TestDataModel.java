package configuration.model;

import lombok.Getter;
import lombok.Setter;

public class TestDataModel {

    @Getter
    @Setter
    private String envName;

    @Getter
    @Setter
    private String appUrl;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String additional;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private String filepath;

    public TestDataModel() {
    }

    public TestDataModel(String envName, String appUrl, String firstName, String lastName, String email, int age, String additional, String message, String filepath) {
        this.envName = envName;
        this.appUrl = appUrl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.additional = additional;
        this.message = message;
        this.filepath = filepath;
    }

    public String filePath() {
        return this.filepath;
    }
}
