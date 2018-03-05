package interfaceDao;

import model.Developer;
import java.util.Collection;

public interface DeveloperDAOInterface {

    int createDeveloper(Developer developer);

    Collection<Developer> findAllDevelopers();

    Developer findDeveloperById(int developerId);

    Developer findDeveloperByUsername(String username);

    Developer findDeveloperByCredentials(String username, String password);

    int updateDeveloper(int developerId, Developer developer);

    int deleteDeveloper(int developerId);
}
