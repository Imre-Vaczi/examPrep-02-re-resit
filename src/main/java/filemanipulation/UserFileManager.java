package filemanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserFileManager {

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return List.copyOf(users);
    }

    public void readUsersFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                populateUsers(line);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can't read file!", ioException);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, selectUsers());
        } catch (IOException ioException) {
            throw new IllegalStateException("Can't write file!", ioException);
        }
    }

    private List<String> selectUsers() {
        List<String> result = new ArrayList<>();
        for (User user : users) {
            if (checkConstraints(user)) {
                result.add(transformUser(user));
            }
        }
        return result;
    }

    private String transformUser(User user) {
        return user.getUserName(); // + " " + user.getYearOfBirth() + " " + user.getEmail();
    }

    private boolean checkConstraints(User user) {
        return user.getEmail().toLowerCase(Locale.ROOT).contains(user.getUserName().toLowerCase(Locale.ROOT));
    }

    private void populateUsers(String line) {
        String name = line.split(" ")[0];
        int born = Integer.parseInt(String.valueOf(line.split(" ")[1]));
        String email = line.split(" ")[2];
        users.add(new User(name, born, email));
    }

    public static void main(String[] args) {
        UserFileManager usf = new UserFileManager();
        User user = new User("iamuser", 1994, "imuser@gmail.com");
        System.out.println(usf.checkConstraints(user));
        System.out.println(usf.transformUser(user));
    }
}
