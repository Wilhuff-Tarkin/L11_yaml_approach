package configuration.model;

import java.util.List;

public class EnvironmentModel {

    public List<PropertyModel> listOfproperties;

   public EnvironmentModel() {
   }

   public EnvironmentModel(List<PropertyModel> listOfproperties) {
      this.listOfproperties = listOfproperties;
   }
}
