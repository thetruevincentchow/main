package seedu.address.model.module;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModuleDataImporter {

    private static final String DOWNLOAD_URL = "https://api.nusmods.com/2019-2020/1/bulletinModulesRaw.json";
    private static Path moduleDataRawPath = Paths.get("data", "bulletinModulesRaw.json");
    private static List<Module> modules = new ArrayList<>();

    public static void run() {
        try {
            if (!Files.exists(moduleDataRawPath)) {
                try (InputStream in = new URL(DOWNLOAD_URL).openStream()) {
                    Files.copy(in, moduleDataRawPath);
                }
            }
            Optional<JsonSerializableModule[]> optionalModules = JsonUtil.readJsonFile(moduleDataRawPath, JsonSerializableModule[].class);
            if (optionalModules.isPresent()) {
                JsonSerializableModule[] moduleArray = optionalModules.get();
                for (JsonSerializableModule m : moduleArray) {
                    try {
                        modules.add(m.toModelType());
                    } catch (IllegalValueException ex) {
                        System.err.println(ex);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
