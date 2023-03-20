package nab.test;

/**
 * @author long.truong@finos.asia
 */
public class TestString2 {

    public String changeDirectoryString(String currentDirectory, String command) {
        validateCommand(command);
        if ("cd /".equals(command))
            return "/";

        String[] isolationCommandArr = genIsolationCommand(command.substring(3));

        for (int i = 0; i < isolationCommandArr.length; i++) {
            currentDirectory = helper(currentDirectory, isolationCommandArr[i]);
        }
        return currentDirectory;

    }

    private String[] genIsolationCommand(String command) {
        String[] arrOfStr = command.split("/");
        return arrOfStr;
    }

    private String helper(String currentDirectory, String command) {
        if ("".equals(command)) {
            return currentDirectory;
        }

        if ("..".equals(command)) {
            for (int i = currentDirectory.length() - 1; i >= 0; i--) {
                if (currentDirectory.charAt(i) == '/') {
                    return currentDirectory.substring(0, i);
                }
            }
        }

        return currentDirectory + "/" + command;
    }

    private void validateCommand(String command) {
        if (command == null)
            return;

        if (!command.startsWith("cd ")) {
            throw new IllegalStateException("wrong command");
        }
    }
}
