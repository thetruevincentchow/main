package seedu.address.model.module;

import seedu.address.model.time.Semester;

import java.util.ArrayList;

public class ModuleOffering {
    private final ModuleCode code;
    private final Description description;
    private final Credit credit;
    protected Semester sem;
    protected boolean isGraded;
    protected ArrayList<Lesson> lessons;

    public ModuleOffering(ModuleCode code, Description description, Credit credit, Semester sem, boolean isGraded, ArrayList<Lesson> lessons) {
        this.code = code;
        this.description = description;
        this.credit = credit;
        this.sem = sem;
        this.isGraded = isGraded;
        this.lessons = lessons;
    }

    public ModuleCode getCode() {
        return this.code;
    }

    public Description getDescription() {
        return this.description;
    }

    public Credit getCredit() {
        return this.credit;
    }

    public Semester getSem() {
        return this.sem;
    }

    public ArrayList<Lesson> getLessons() {
        return this.lessons;
    }
}
