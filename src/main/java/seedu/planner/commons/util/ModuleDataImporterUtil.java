package seedu.planner.commons.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.planner.Main;
import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.storage.JsonSerializableModule;
import seedu.planner.model.module.Module;

/**
 * Helper Class to import Module data from a JSON file retrieved from NUS Mods API
 */
public class ModuleDataImporterUtil {

    private static final String DOWNLOAD_URL = "https://api.nusmods.com/v2/{0}/moduleInfo.json";
    private static final String[] acadYears = new String[]{
        "2019-2020",
        "2018-2019"
    };
    private static List<Module> modules = new ArrayList<>();

    public static List<Module> run() {
        Module module;
        String fileName = "";
        for (String acadYear : acadYears) {
            try {
                fileName = "json/moduleInfo_{0}.json".replace("{0}", acadYear);
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                String text = new Scanner(Main.class.getClassLoader().getResourceAsStream(fileName),
                        "UTF-8").useDelimiter("\\A").next();
                Optional<JsonSerializableModule[]> optionalModules = JsonUtil.readJsonString(text,
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
        return FXCollections.unmodifiableObservableList(FXCollections.observableArrayList(modules));
    }
}
