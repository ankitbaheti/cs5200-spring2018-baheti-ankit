package model;

public class main {
    public static void main(String args[]){

        DeveloperDAO developerDAO = DeveloperDAO.getInstance();
        PageDAO pageDAO = PageDAO.getInstance();
        PriviledgeDAO priviledgeDAO = PriviledgeDAO.getInstance();
        RoleDAO roleDAO = RoleDAO.getInstance();
        UserDAO userDAO = UserDAO.getInstance();
        WebsiteDAO webDAO = WebsiteDAO.getInstance();
        WidgetDAO widgetDAO = WidgetDAO.getInstance();

        Person alice = new Person(1, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", null);
        Developer dev = new Developer(1, "4321rewq", alice);
        int result = developerDAO.createDeveloper(dev);
        if(result == 1){
            System.out.println("success");
        }
    }
}
