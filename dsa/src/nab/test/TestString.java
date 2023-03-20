package nab.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author long.truong@finos.asia
 */
public class TestString {

    public static final String COMMAND_PREFIX = "cd";

    public static void main(String[] args) {
        String currentDirectory = "/dev/task";
        // String command = "cd ../../abc";
        String command = "cd /a/";

        changeDirectoryString(currentDirectory, command);
    }

    public static String changeDirectoryString(String currentDirectory, String command) {

        if (command == null || command.length() < 4)
            throw new IllegalStateException("Invalid command");

        if (!COMMAND_PREFIX.equalsIgnoreCase(command.substring(0, 2)))
            throw new IllegalStateException("Not start with cd");

        if (' ' != command.charAt(2))
            throw new IllegalStateException("Missing space after cd");

        String realPath = command.substring(3);
        List<String> commands = getCommands(realPath);
        Stack<String> directoriesStack = getDirectories(currentDirectory);

        for (String subCommand: commands) {
            if ("".equals(subCommand)) {
                directoriesStack.empty();
            } else if ("..".equals(subCommand)) {
                directoriesStack.pop();
            } else {
                directoriesStack.push(subCommand);
            }
        }

        return null;

    }



    public static Stack<String> getDirectories(String currentPath) {

        Stack<String> result = new Stack<>();

        if (currentPath.endsWith("/")) {
            currentPath =  currentPath.substring(0, currentPath.length() -1);
        }

        String[] segments = currentPath.split("/");

        for (String segment: segments) {
            result.push(segment);
        }

        return result;
    }

    public static List<String> getCommands(String command) {

        if (command.endsWith("/")) {
            command =  command.substring(0, command.length() -1);
        }

        String[] segments = command.split("/");

        List<String> result = new ArrayList<>(Arrays.asList(segments));

        return result;
    }
}
