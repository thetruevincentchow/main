package seedu.address.model.student;


import seedu.address.model.programmes.DegreeProgramme;

import java.util.Objects;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student {

    // Identity fields
    private final Name name;

    private final Degrees degrees;

    private final Major major;

    /**
     * Every field must be present and not null.
     */
    public Student(Name name) {
        this(name, new Degrees(), null);
    }

    //TODO: add `degrees` field in `JsonAdaptedStudent` and remove this constructor
    public Student(Name name, Major major) {
        requireAllNonNull(name);
        this.name = name;
        this.degrees = null;
        this.major = major;
    }

    public Student(Name name, Degrees degrees, Major major) {
        requireAllNonNull(name);
        this.name = name;
        this.degrees = degrees;
        this.major = major;
    }

    public Name getName() {
        return name;
    }

    public Major getMajor() {
        return major;
    }

    public Degrees getDegrees() {
        return this.degrees;
    }

    public boolean addDegrees(DegreeProgramme degree) {
        this.degrees.addDegree(degree);
        return true;
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

        Student otherStudent = (Student) other;
        //TODO: initialize and compare `degrees`
        return otherStudent.getName().equals(getName()) && otherStudent.getMajor().equals(getMajor());// && otherStudent.degrees.equals(getDegrees());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName());
        builder.append("major/").append(getName());
        return builder.toString();
    }

    public boolean isSameStudent(Student student) {
        return this.equals(student);
    }

}
