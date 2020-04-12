package seedu.planner.commons.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.planner.Main;
import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.storage.JsonSerializableModule;

/**
 * Helper Class to import Module data from a JSON file retrieved from NUS Mods API.
 */
public class ModuleDataImporterUtil {

    private static final String DOWNLOAD_URL = "https://api.nusmods.com/v2/{0}/moduleInfo.json";
    private static final String[] acadYears = new String[]{
        "2019-2020",
        "2018-2019"
    };
    private static List<Module> modules = new ArrayList<>();

    /**
     * Adds a {@code Module} to the global repository of modules.
     *
     * @param module {@code Module} to be added.
     */
    public static void addModule(Module module) {
        if (!modules.contains(module)) {
            modules.add(module);
        }
    }

    /**
     * Performs the conversion of modules stored in a JSON into a list of {@code Module} objects.
     *
     * @return A list of {@code Module} objects
     */
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
                            addModule(m.toModelType());
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
        addModule(new Module(new ModuleCode("POY1901"), "4"));
        addModule(new Module(new ModuleCode("POY1902"), "4"));
        addModule(new Module(new ModuleCode("POY1903"), "4"));
        addModule(new Module(new ModuleCode("POY1908"), "4"));
        addModule(new Module(new ModuleCode("POY1909"), "4"));
        return modules;
    }

    public ObservableList<Module> getFilteredModuleList() {
        return FXCollections.unmodifiableObservableList(FXCollections.observableArrayList(modules));
    }
}
