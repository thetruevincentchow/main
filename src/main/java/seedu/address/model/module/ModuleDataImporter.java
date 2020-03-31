package seedu.address.model.module;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;


public class ModuleDataImporter {

    private static final String DOWNLOAD_URL = "https://api.nusmods.com/v2/{0}/moduleInfo.json";
    private static final String[] acadYears = new String[] {
        "2019-2020",
        "2018-2019"
    };
    private static List<Module> modules = new ArrayList<>();

    public static List<Module> run() {
        File file;
        Module module;
        String fileName = "";
        for (String acadYear : acadYears) {
            try {
                fileName = "json/moduleInfo_{0}.json".replace("{0}", acadYear);
                ClassLoader classLoader = new ModuleDataImporter().getClass().getClassLoader();
                file = new File(classLoader.getResource(fileName).getFile());
                if (!file.exists()) {
                    throw new Exception("Resource " + fileName + " is not found.");
                }
                Optional<JsonSerializableModule[]> optionalModules = JsonUtil.readJsonFile(Path.of(file.getPath()),
                    JsonSerializableModule[].class);
                if (optionalModules.isPresent()) {
                    JsonSerializableModule[] moduleArray = optionalModules.get();
                    for (JsonSerializableModule m : moduleArray) {
                        try {
                            module = m.toModelType();
                            if (!modules.contains(module)) {
                                modules.add(module);
                            }
                        } catch (IllegalValueException ex) {
                            System.err.println(ex);
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("Error loading file: " + fileName);
                System.err.println(e);
            }
        }
        return modules;
    }

    public ObservableList<Module> getFilteredModuleList() {
        ObservableList<Module> oList = FXCollections.observableArrayList(modules);
        return oList;
    }
}
