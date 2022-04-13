package configuration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;

public class EnvironmentModel {

    @JsonAnyGetter
    @JsonAnySetter
    private HashMap<String, Object> mapOfProperties = new HashMap<>();

    public EnvironmentModel() {
    }

    public EnvironmentModel(HashMap<String, Object> mapOfProperties) {
        this.mapOfProperties = mapOfProperties;
    }

    public HashMap<String, Object> getMapOfProperties() {
        return mapOfProperties;
    }

   @Override
   public String toString() {
      return "EnvironmentModel{" +
              "mapOfProperties=" + mapOfProperties +
              '}';
   }


   public String returnStringValue (String key) {

        if (mapOfProperties.containsKey(key)){
            return mapOfProperties.get(key).toString();
        } else {
            System.out.println("No property stored under this key in current environment.");
            return null;
        }
   }

}
