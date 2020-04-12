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


    public Student(Name name, Major major) {
        requireAllNonNull(name, major);
        this.name = name;
        this.major = major;
        this.timeTableMap = new TimeTableMap();
    }

    public Student(Name name, Major major, TimeTableMap timeTableMap, List<ModuleCode> exemptedModules) {
        requireAllNonNull(name, major, timeTableMap);
        this.name = name;
        this.major = major;
        this.timeTableMap = timeTableMap;
        exemptedModules.forEach(this.exemptedModules::add);
        this.lessons = new ArrayList<>();
    }


    public Student(Name name, Major major, TimeTableMap timeTableMap, List<ModuleCode> exemptedModules,
                   GenericSpecialisation specialisation) {
        this(name, major, timeTableMap, exemptedModules);
        // this.specialisation = specialisation;
        setSpecialisation(specialisation);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        requireAllNonNull(name);
        this.name = name;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public TimeTableMap getTimeTableMap() {
        return timeTableMap;
    }

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

    @Override
    public int hashCode() {
        /**
         * NOTE: {@code specialisation} and {@code lessons} are not hashed because
         * {@code GenericSpecialisation#hashCode()} and {@code Lesson#hashCode()}
         * and its subclasses are not implemented.
         */
        return Objects.hash(name, major, timeTableMap, exemptedModules);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(PREFIX_NAME).append(getName()).append(" ")
                .append(PREFIX_MAJOR).append(getMajor());
        return builder.toString();
    }

    public boolean isSameStudent(Student other) {
        return this.name.equals(other.name);
    }

    public TimeTable getTimeTable(StudentSemester activeSemester) {
        return timeTableMap.get(activeSemester);
    }

    public void replaceTimeTable(StudentSemester activeSemester, TimeTable timeTable) {
        timeTableMap.put(activeSemester, timeTable);
    }

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

    public ObservableList<Enrollment> getAllEnrollments() {
        ObservableList<Enrollment> allEnrollments = FXCollections.observableArrayList();
        for (TimeTable timeTable : timeTableMap.values()) {
            allEnrollments.addAll(timeTable.getEnrollments().asUnmodifiableObservableList());
        }
        return allEnrollments;
    }

    public GenericSpecialisation getSpecialisation() {
        return specialisation;
    }

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

    public ObservableList<ModuleCode> getExemptedModules() {
        return exemptedModules.asUnmodifiableObservableList();
    }

    public void addExemptedModule(ModuleCode moduleCode) {
        exemptedModules.add(moduleCode);
    }

    public void removeExemptedModule(ModuleCode moduleCode) {
        exemptedModules.remove(moduleCode);
    }

    public List<ModuleCode> getAllFulfilledModules() {
        Set<ModuleCode> moduleCodeSet = new HashSet<>();
        moduleCodeSet.addAll(getAllEnrolledModules());
        moduleCodeSet.addAll(getExemptedModules());
        return moduleCodeSet.stream().collect(Collectors.toList());
    }

    public void addLessons(Lesson lesson) {
        lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        if (lessons.contains(lesson)) {
            lessons.remove(lesson);
        }
    }
}
