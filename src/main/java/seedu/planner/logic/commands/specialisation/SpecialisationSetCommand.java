package seedu.planner.logic.commands.specialisation;

import static java.util.Objects.requireNonNull;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.programmes.specialisations.GenericSpecialisation;
import seedu.planner.model.programmes.specialisations.cs.AlgorithmsAndTheorySpecialisation;
import seedu.planner.model.programmes.specialisations.cs.ArtificialIntelligenceSpecialisation;
import seedu.planner.model.programmes.specialisations.cs.ComputerGraphicsAndGamesSpecialisation;
import seedu.planner.model.programmes.specialisations.cs.ComputerSecuritySpecialisation;
import seedu.planner.model.programmes.specialisations.cs.DatabaseSystemsSpecialisation;
import seedu.planner.model.programmes.specialisations.cs.MultimediaInformationRetrievalSpecialisation;
import seedu.planner.model.programmes.specialisations.cs.NetworkingAndDistributedSystemsSpecialisation;
import seedu.planner.model.programmes.specialisations.cs.ParallelComputingSpecialisation;
import seedu.planner.model.programmes.specialisations.cs.ProgrammingLanguagesSpecialisation;
import seedu.planner.model.programmes.specialisations.cs.SoftwareEngineeringSpecialisation;
import seedu.planner.model.programmes.specialisations.is.DigitalInnovationSpecialisation;
import seedu.planner.model.programmes.specialisations.is.ElectronicCommerceSpecialisation;
import seedu.planner.model.programmes.specialisations.is.FinancialTechnologySpecialisation;
import seedu.planner.model.student.Student;

/**
 * Sets the {@code Specialisation} of the current active {@code Student}.
 */
public class SpecialisationSetCommand extends SpecialisationCommand {
    public static final String COMMAND_WORD = "set";
    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'" + getQualifiedCommand(COMMAND_WORD)
            + "' command not implemented yet";
    public static final String MESSAGE_SUCCESS = "Successfully updated Student's Focus Area to: %1$s";
    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
            + ": Set's the current Student's specialisation";
    public static final String INVALID_SPECIALISATION = "Invalid Specialisation.";
    public static final String CS_SPECIALISATION_EXAMPLES = "\nValid Specialisations for CS:\n"
            + "1. (at) Algorithms & Theory\n"
            + "2. (ai) Artificial Intelligence\n"
            + "3. (cgg) Computer Graphics and Games\n"
            + "4. (cs) Computer Security\n"
            + "5. (ds) Database Systems\n"
            + "6. (mir) Multimedia Information Retrieval\n"
            + "7. (nds) Networking and Distributed Systems\n"
            + "8. (pc) Parallel Computing\n"
            + "9. (pl) Programming Languages\n"
            + "10. (se) Software Engineering\n"
            + "\n"
            + "Example:\n"
            + "\t specialisation set 1\n"
            + "\t specialisation set at\n";
    public static final String IS_SPECIALISATION_EXAMPLES = "\nValid Specialisations for IS:\n"
            + "1. (di) Digital Innovation\n"
            + "2. (ec) Electronic Commerce\n"
            + "3. (ft) Financial Technology\n"
            + "\n"
            + "Example:\n"
            + "\t specialisation set 1\n"
            + "\t specialisation set di\n";
    public static final String INVALID_MAJOR = "Invalid Major";

    /**
     * Stores user input for selecting {@code Specialisation}.
     */
    private String input = "";
    /**
     * Stores the {@code GenericSpecialisation} to be used for setting the specialisation of the active {@code Student}.
     */
    private GenericSpecialisation specialisation;

    /**
     * Default constructor for {@code SpecialisationSetCommand}.
     *
     * @param specialisation {@code GenericSpecialisation} to be set
     */
    public SpecialisationSetCommand(GenericSpecialisation specialisation) {
        this.specialisation = specialisation;
    }

    public SpecialisationSetCommand(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    /**
     * Returns {@code GenericSpecialisation} to be used for setting the specialisation of the active {@code Student}.
     *
     * @return {@code GenericSpecialisation} to be used for setting the specialisation of the active {@code Student}
     */
    public GenericSpecialisation getSpecialisation() {
        return specialisation;
    }

    /**
     * Sets the {@code GenericSpecialisation} to be used for setting the specialisation of the active {@code Student}.
     *
     * @param specialisation {@code GenericSpecialisation} to be used for setting the specialisation of the
     *                       active {@code Student}
     */
    public void setSpecialisation(GenericSpecialisation specialisation) {
        this.specialisation = specialisation;
    }


    /**
     * Executes {@code SpecialisationSetCommand}.
     *
     * @param model {@code Model} which the command should operate on
     * @return {@code CommandResult} produced from executing the command
     * @throws CommandException when an exception occurred while executing the command
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student activeStudent = model.getActiveStudent();
        if (activeStudent == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }
        try {
            switch (activeStudent.getMajor().toString()) {
            case "CS":
                switch (input) {
                case "1":
                case "at":
                    specialisation = new AlgorithmsAndTheorySpecialisation();
                    break;
                case "2":
                case "ai":
                    specialisation = new ArtificialIntelligenceSpecialisation();
                    break;
                case "3":
                case "cgg":
                    specialisation = new ComputerGraphicsAndGamesSpecialisation();
                    break;
                case "4":
                case "cs":
                    specialisation = new ComputerSecuritySpecialisation();
                    break;
                case "5":
                case "ds":
                    specialisation = new DatabaseSystemsSpecialisation();
                    break;
                case "6":
                case "mir":
                    specialisation = new MultimediaInformationRetrievalSpecialisation();
                    break;
                case "7":
                case "nds":
                    specialisation = new NetworkingAndDistributedSystemsSpecialisation();
                    break;
                case "8":
                case "pc":
                    specialisation = new ParallelComputingSpecialisation();
                    break;
                case "9":
                case "pl":
                    specialisation = new ProgrammingLanguagesSpecialisation();
                    break;
                case "10":
                case "se":
                    specialisation = new SoftwareEngineeringSpecialisation();
                    break;
                default:
                    throw new CommandException(INVALID_SPECIALISATION + CS_SPECIALISATION_EXAMPLES);
                }
                break;
            case "IS":
                switch (input) {
                case "1":
                case "di":
                    specialisation = new DigitalInnovationSpecialisation();
                    break;
                case "2":
                case "ec":
                    specialisation = new ElectronicCommerceSpecialisation();
                    break;
                case "3":
                case "ft":
                    specialisation = new FinancialTechnologySpecialisation();
                    break;
                default:
                    throw new CommandException(INVALID_SPECIALISATION + IS_SPECIALISATION_EXAMPLES);
                }
                break;
            default:
                throw new CommandException(INVALID_MAJOR);
            }
        } catch (IllegalArgumentException e) {
            throw new CommandException(e.getMessage());
        }
        activeStudent.setSpecialisation(specialisation);
        return new CommandResult(String.format(MESSAGE_SUCCESS, specialisation.toString()));
    }
}
