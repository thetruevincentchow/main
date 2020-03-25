package seedu.address.logic.commands.specialisation;

import seedu.address.logic.commands.Command;

public abstract class SpecialisationCommand extends Command {

    public static final String COMMAND_WORD = "specialisation";

    // TODO: fill in usage message
    public static final String MESSAGE_USAGE = COMMAND_WORD
        //+ ": Deletes the person identified by the index number used in the displayed person list.\n"
        //+ "Parameters: INDEX (must be a positive integer)\n"
        + ":\n"
        + "1. Algorithms & Theory\n"
        + "2. Artificial Intelligence\n"
        + "3. Computer Graphics and Games\n"
        + "4. Computer Security\n"
        + "5. Database Systems\n"
        + "6. Multimedia Information Retrieval\n"
        + "7. Networking and Distributed Systems\n"
        + "8. Parallel Computing\n"
        + "9. Programming Languages\n"
        + "10. Software Engineering\n"
        + "Subcommands: set\n"
        + "Example: " + COMMAND_WORD + " set 1";


    public static String getQualifiedCommand(String subCommand) {
        return COMMAND_WORD + " " + subCommand;
    }
}
