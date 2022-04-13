package configuration.model;

import lombok.Getter;

public class PropertyModel {

    @Getter
    private String key;

    @Getter
    private String value;

    public PropertyModel() {
    }

    public PropertyModel(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
