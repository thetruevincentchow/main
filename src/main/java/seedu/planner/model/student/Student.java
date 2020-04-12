package seedu.planner.model.student;

import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.planner.model.grades.CumulativeGrade;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.graduation.SpecialisationGraduationRequirement;
import seedu.planner.model.module.Lesson;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.module.UniqueModuleCodeList;
import seedu.planner.model.programmes.specialisations.GenericSpecialisation;
import seedu.planner.model.student.exceptions.SemesterKeyNotFoundException;
import seedu.planner.model.time.StudentSemester;

/**
 * Represents a Student in the planner.
 * Guarantees: details are present and not null, field values are validated. Mutable.
 */
public class Student {

    // Timetables
    public final TimeTableMap timeTableMap;
    // Exemptions
    public final UniqueModuleCodeList exemptedModules = new UniqueModuleCodeList();
    // Identity fields
    private Name name;
    private Major major;
    private GenericSpecialisation specialisation;
    private List<Lesson> lessons;

    /**
     * Parameterised Constructor of {@code Student} with the given parameters
     * @param name {@code Name} of {@code Student}
     * @param major {@code Major} of {@code Student}
     */
    public Student(Name name, Major major) {
        requireAllNonNull(name, major);
        this.name = name;
        this.major = major;
        this.timeTableMap = new TimeTableMap();
    }

    /**
     * Parameterised Constructor of {@code Student} with the given parameters
     * @param name {@code Name} of {@code Student}
     * @param major {@code Major} of {@code Student}
     * @param timeTableMap {@code TimeTableMap} of {@code Student}
     * @param exemptedModules List of {@code ModuleCode} representing the exempted {@code Modules} of {@code Student}
     */
    public Student(Name name, Major major, TimeTableMap timeTableMap, List<ModuleCode> exemptedModules) {
        requireAllNonNull(name, major, timeTableMap);
        this.name = name;
        this.major = major;
        this.timeTableMap = timeTableMap;
        exemptedModules.forEach(this.exemptedModules::add);
        this.lessons = new ArrayList<>();
    }

    /**
     * Parameterised Constructor of {@code Student} with the given parameters
     * @param name {@code Name} of {@code Student}
     * @param major {@code Major} of {@code Student}
     * @param timeTableMap {@code TimeTableMap} of {@code Student}
     * @param exemptedModules List of {@code ModuleCode} representing the exempted {@code Modules} of {@code Student}
     * @param specialisation {@code Specialisation} of {@code Student}
     */
    public Student(Name name, Major major, TimeTableMap timeTableMap, List<ModuleCode> exemptedModules,
                   GenericSpecialisation specialisation) {
        this(name, major, timeTableMap, exemptedModules);
        setSpecialisation(specialisation);
    }

    /**
     * Gets the {@code Name} of the {@code Student}
     * @return The {@code Name} of the {@code Student}
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the {@code Name} of the {@code Student}
     * @param name {@code Name} of the {@code Student} to be set
     */
    public void setName(Name name) {
        requireAllNonNull(name);
        this.name = name;
    }

    /**
     * Gets the {@code Major} for the {@code Student}
     * @return The {@code Major} for the {@code Student}
     */
    public Major getMajor() {
        return major;
    }

    /**
     * Sets the {@code Major} for the {@code Student}
     * @param major {@code Major} to be set
     */
    public void setMajor(Major major) {
        this.major = major;
    }

    /**
     * Gets the {@code TimeTableMap} for the {@code Student}
     * @return {@code TimeTableMap} for the {@code Student}
     */
    public TimeTableMap getTimeTableMap() {
        return timeTableMap;
    }

    /**
     * Gets the list of {@code Lesson} for the {@code Student}
     * @return List of {@code Lesson} for the {@code Student}
     */
    public List<Lesson> getLesson() {
        return lessons;
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Student)) {
            return false;
        }

        /**
         * NOTE: {@code specialisation} and {@code lessons} are not compared because
         * {@code GenericSpecialisation#equal()} and {@code Lesson#equal()}
         * and its subclasses are not implemented.
         */
        Student otherStudent = (Student) other;
        return otherStudent.getName().equals(getName())
                && otherStudent.getMajor().equals(getMajor())
                && otherStudent.getTimeTableMap().equals(getTimeTableMap());
    }

    /**
     * Returns the hashCode of the {@code Student} object
     * @return The hashCode of the {@code Student} object
     */
    @Override
    public int hashCode() {
        /**
         * NOTE: {@code specialisation} and {@code lessons} are not hashed because
         * {@code GenericSpecialisation#hashCode()} and {@code Lesson#hashCode()}
         * and its subclasses are not implemented.
         */
        return Objects.hash(name, major, timeTableMap, exemptedModules);
    }

    /**
     * Returns the String Representation of the {@code Student} object
     * @return The String Representation of the {@code Student} object
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(PREFIX_NAME).append(getName()).append(" ")
                .append(PREFIX_MAJOR).append(getMajor());
        return builder.toString();
    }

    /**
     * Checks if the current {@code Student} is the same as a specified {@code Student}
     * @param other Another {@code Student} object
     * @return True if the two {@code Student} objects are the same. False otherwise.
     */
    public boolean isSameStudent(Student other) {
        return this.name.equals(other.name);
    }

    /**
     * Returns the given Timetable of a {@code Student} for a specified {@code StudentSemester}
     * @param activeSemester {@code Semester} to be conferred
     * @return {@code Timetable} of {@code Student} for the specified {@code StudentSemester}
     */
    public TimeTable getTimeTable(StudentSemester activeSemester) {
        return timeTableMap.get(activeSemester);
    }

    /**
     * Replaces the active Timetable with a given TimeTable
     * @param activeSemester {@code Semester} to be made active
     * @param timeTable Timetable of the {@code Student}
     */
    public void replaceTimeTable(StudentSemester activeSemester, TimeTable timeTable) {
        timeTableMap.put(activeSemester, timeTable);
    }

    /**
     * Removes a given TimeTable from a {@code Student}
     * @param keyToRemove TimeTable to be removed
     */
    public void removeTimeTable(StudentSemester keyToRemove) {
        if (!timeTableMap.containsKey(keyToRemove)) {
            throw new SemesterKeyNotFoundException();
        }
        timeTableMap.remove(keyToRemove);
    }

    /**
     * Returns a sorted list of {@code StudentSemester} for the timetables of the student.
     * {@link StudentSemester}s are sorted with the order given by {@link StudentSemester::compareTo}.
     *
     * @return Sorted list of semesters of timetables.
     */
    public List<StudentSemester> getStudentSemesters() {
        List<StudentSemester> studentSemesters = new ArrayList<>(timeTableMap.keySet());
        studentSemesters.sort(StudentSemester::compareTo);
        return studentSemesters;
    }

    /**
     * Returns {@code true} if the student has a timetable with the specified {@code studentSemester}
     * @param studentSemester {@link StudentSemester} of a timetable
     * @return {@code true} if the student has a timetable with the specified {@code studentSemester}
     */
    public boolean hasStudentSemester(StudentSemester studentSemester) {
        return timeTableMap.containsKey(studentSemester);
    }

    /**
     * Returns a list of {@link ModuleCode} taken across all timetables.
     *
     * @return List of all modules enrolled.
     */
    public ObservableList<ModuleCode> getAllEnrolledModules() {
        ObservableList<ModuleCode> allModules = FXCollections.observableArrayList();
        for (TimeTable timeTable : timeTableMap.values()) {
            allModules.addAll(timeTable.getModuleCodes());
        }
        return allModules;
    }

    /**
     * Gets all {@code Enrollment} of the {@code Student}
     * @return A list of {@code Enrollment} of the {@code Student}
     */
    public ObservableList<Enrollment> getAllEnrollments() {
        ObservableList<Enrollment> allEnrollments = FXCollections.observableArrayList();
        for (TimeTable timeTable : timeTableMap.values()) {
            allEnrollments.addAll(timeTable.getEnrollments().asUnmodifiableObservableList());
        }
        return allEnrollments;
    }

    /**
     * Gets the Specialisation of the {@code Student}
     * @return The Specialisation of the {@code Student}
     */
    public GenericSpecialisation getSpecialisation() {
        return specialisation;
    }

    /**
     * Sets the {@code Specialisation} of the {@code Student}
     * @param specialisation Specialisation to be set
     */
    public void setSpecialisation(GenericSpecialisation specialisation) {
        this.specialisation = specialisation;
        for (GraduationRequirement graduationRequirement : this.major.getDegreeProgramme()
                .getTerminalGraduationRequirementList()) {
            if (graduationRequirement instanceof SpecialisationGraduationRequirement) {
                SpecialisationGraduationRequirement specialisationGraduationRequirement =
                        (SpecialisationGraduationRequirement) graduationRequirement;
                specialisationGraduationRequirement.setSpecialisation(specialisation);
            }
        }
    }

    /**
     * Returns the cumulative grade of a {@code Student}
     * @return The cumulative grade of a {@code Student}
     */
    public CumulativeGrade getCumulativeGrade() {
        CumulativeGrade cumulativeGrade = new CumulativeGrade();
        for (Enrollment enrollment : getAllEnrollments()) {
            Optional<Grade> optionalGrade = enrollment.getGrade();
            if (optionalGrade.isPresent()) {
                cumulativeGrade.accumulate(optionalGrade.get(), enrollment.getCredit());
            } else {
                cumulativeGrade.accumulatePending(enrollment.getCredit());
            }
        }
        return cumulativeGrade;
    }

    /**
     * Returns a list of exempted {@code Module}
     * @return A list of exempted {@code Module}
     */
    public ObservableList<ModuleCode> getExemptedModules() {
        return exemptedModules.asUnmodifiableObservableList();
    }

    /**
     * Adds a {@code Module} for exemption.
     * @param moduleCode {@code ModuleCode} of a {@code Module} to be added for exemption
     */
    public void addExemptedModule(ModuleCode moduleCode) {
        exemptedModules.add(moduleCode);
    }

    /**
     * Removes a {@code Module} from exemption.
     * @param moduleCode {@code ModuleCode} of a {@code Module} to be removed from exemption
     */
    public void removeExemptedModule(ModuleCode moduleCode) {
        exemptedModules.remove(moduleCode);
    }

    /**
     * Returns all the fulfilled and exempted {@code Module} of a {@code Student}
     * @return All the fulfilled and exempted {@code Module} of a {@code Student}
     */
    public List<ModuleCode> getAllFulfilledModules() {
        Set<ModuleCode> moduleCodeSet = new HashSet<>();
        moduleCodeSet.addAll(getAllEnrolledModules());
        moduleCodeSet.addAll(getExemptedModules());
        return moduleCodeSet.stream().collect(Collectors.toList());
    }

    /**
     * Adds a given {@code Lesson} to a {@code Student}
     * @param lesson {@code Lesson} to be added
     */
    public void addLessons(Lesson lesson) {
        lessons.add(lesson);
    }

    /**
     * Removes a given {@code Lesson} to a {@code Student}
     * @param lesson {@code Lesson} to be removed
     */
    public void removeLesson(Lesson lesson) {
        if (lessons.contains(lesson)) {
            lessons.remove(lesson);
        }
    }
}
