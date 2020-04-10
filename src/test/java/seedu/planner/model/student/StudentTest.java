package seedu.planner.model.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static seedu.planner.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.planner.model.programmes.specialisations.cs.AlgorithmsAndTheorySpecialisation;
import seedu.planner.testutil.TypicalStudents;

class StudentTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Student(null, null));
    }

    @Test
    public void getName_valid() {
        Student existingStudent = TypicalStudents.ALICE;
        assertEquals(existingStudent.getName(), new Name("Alice"));
        Student newStudent = new Student(new Name("Bob"), new Major("CS"));
        assertEquals(newStudent.getName(), new Name("Bob"));
    }

    @Test
    public void setName_valid() {
        Student newStudent = new Student(new Name("Charlie"), new Major("CS"));
        assertEquals(newStudent.getName(), new Name("Charlie"));
        newStudent.setName(new Name("Darren"));
        assertEquals(newStudent.getName(), new Name("Darren"));
    }

    @Test
    public void setName_null_throwsNullPointerException() {
        Student newStudent = new Student(new Name("Charlie"), new Major("CS"));
        assertEquals(newStudent.getName(), new Name("Charlie"));
        assertThrows(NullPointerException.class, () -> newStudent.setName(null));
    }

    @Test
    public void setName_empty_throwsIllegalArgumentException() {
        Student newStudent = new Student(new Name("Charlie"), new Major("CS"));
        assertEquals(newStudent.getName(), new Name("Charlie"));
        assertThrows(IllegalArgumentException.class, () -> newStudent.setName(new Name("")));
    }

    @Test
    public void getMajor_valid_majorCs() {
        Student existingStudent = TypicalStudents.ALICE;
        assertEquals(existingStudent.getMajor(), new Major("CS"));
        Student newStudent = new Student(new Name("Bob"), new Major("CS"));
        assertEquals(newStudent.getMajor(), new Major("CS"));
    }

    @Test
    public void getMajor_valid_majorIs() {
        Student existingStudent = TypicalStudents.BOB;
        assertEquals(existingStudent.getMajor(), new Major("IS"));
        Student newStudent = new Student(new Name("Bob"), new Major("IS"));
        assertEquals(newStudent.getMajor(), new Major("IS"));
    }

    @Test
    public void setMajor_valid_majorCsToIs() {
        Student newStudent = new Student(new Name("Charlie"), new Major("CS"));
        assertEquals(newStudent.getMajor(), new Major("CS"));
        newStudent.setMajor(new Major("IS"));
        assertEquals(newStudent.getMajor(), new Major("IS"));
    }

    @Test
    public void setMajor_valid_majorIsToCs() {
        Student newStudent = new Student(new Name("Charlie"), new Major("IS"));
        assertEquals(newStudent.getMajor(), new Major("IS"));
        newStudent.setMajor(new Major("CS"));
        assertEquals(newStudent.getMajor(), new Major("CS"));
    }

    @Test
    public void testEquals() {
        Student existingStudent = TypicalStudents.ALICE;
        assertEquals(existingStudent, new Student(new Name("Alice"), new Major("CS")));
    }


    @Test
    public void testEquals_false_differentName() {
        Student existingStudent = TypicalStudents.ALICE;
        assertNotEquals(existingStudent, new Student(new Name("Bob"), new Major("CS")));
    }

    @Test
    public void testEquals_false_differentMajor() {
        Student existingStudent = TypicalStudents.ALICE;
        assertNotEquals(existingStudent, new Student(new Name("Alice"), new Major("IS")));
    }

    @Test
    public void getTimeTableMap() {
    }

    @Test
    public void getLesson() {
    }

    @Test
    public void isSameStudent() {
    }

    @Test
    public void getTimeTable() {
    }

    @Test
    public void setTimeTable() {
    }

    @Test
    public void removeTimeTable() {
    }

    @Test
    public void getStudentSemesters() {
    }

    @Test
    public void getAllEnrolledModules() {
    }

    @Test
    public void getAllEnrollments() {
    }

    @Test
    public void getSpecialisation() {
        Student newStudent = new Student(new Name("Charlie"), new Major("CS"));
        assertNull(newStudent.getSpecialisation());
    }

    @Test
    public void setSpecialisation() {
        Student newStudent = new Student(new Name("Charlie"), new Major("CS"));
        newStudent.setSpecialisation(new AlgorithmsAndTheorySpecialisation());
        assertEquals(newStudent.getSpecialisation(), new AlgorithmsAndTheorySpecialisation());
    }

    @Test
    public void getCumulativeGrade() {
    }

    @Test
    public void getExemptedModules() {
    }

    @Test
    public void addExemptedModule() {
    }

    @Test
    public void removeExemptedModule() {
    }

    @Test
    public void getAllFulfilledModules() {
    }

    @Test
    public void addLessons() {
    }

    @Test
    public void removeLesson() {
    }
}
