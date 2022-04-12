package configuration.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.model.YamlModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class YamlReader {

    public static YamlModel model;
    private static final Logger log = LoggerFactory.getLogger("YamlReader.class");

    public YamlModel reader() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("config.yaml").getFile());
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            return mapper.readValue(file, YamlModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }
}
