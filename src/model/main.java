package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class main {
    public static void main(String args[]){

        DeveloperDAO developerDAO = DeveloperDAO.getInstance();
        PageDAO pageDAO = PageDAO.getInstance();
        PriviledgeDAO priviledgeDAO = PriviledgeDAO.getInstance();
        RoleDAO roleDAO = RoleDAO.getInstance();
        UserDAO userDAO = UserDAO.getInstance();
        WebsiteDAO webDAO = WebsiteDAO.getInstance();
        WidgetDAO widgetDAO = WidgetDAO.getInstance();

        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new Date(date.getTime());
        Date date1 = Date.valueOf("2018-01-08");
        Date date2 = Date.valueOf("2018-03-07");

        Person alice = new Person(1, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", null);
        Developer devAlice = new Developer(1, "4321rewq", alice);
        int result = developerDAO.createDeveloper(devAlice);
        if(result == 1)
            System.out.println("Successfully added Alice");

        Person bob = new Person(2, "Bob", "Marley", "bob", "bob", "bob@marley.com", null);
        Developer devBob = new Developer(2, "5432trew", bob);
        result = developerDAO.createDeveloper(devBob);
        if(result == 1)
            System.out.println("Successfully added Bob");

        Person charlie = new Person(3, "Charles", "Garcis", "charlie", "charlie", "chuch@garcia.com", null);
        Developer devCharlie = new Developer(3, "6543ytre", charlie);
        result = developerDAO.createDeveloper(devCharlie);
        if(result == 1)
            System.out.println("Successfully added Bob");

        Person dan = new Person(4, "Dan", "Martin", "dan", "dan", "dan@martin.com", null);
        User usrDan = new User(1, "7654fda", false, dan);
        result = userDAO.createUser(usrDan);
        if(result == 1)
            System.out.println("Successfully added Dan");

        Person ed = new Person(5, "Ed" , "Karaz", "ed", "ed", "ed@kar.com",null);
        User usrEd = new User(2, "5678dfgh", false, ed);
        result = userDAO.createUser(usrEd);
        if (result == 1)
            System.out.println("Successfully added Ed");

        List<WebsiteRole> websiteRoleList = new ArrayList<>();
        WebsiteRole owner = new WebsiteRole("Facebook", "alice", "owner");
        WebsiteRole editor = new WebsiteRole("Facebook", "bob", "editor");
        WebsiteRole admin = new WebsiteRole("Facebook", "charlie", "admin");
        websiteRoleList.add(owner);
        websiteRoleList.add(editor);
        websiteRoleList.add(admin);
        Website Facebook = new Website(1, "Facebook", "an online social media and social networking service", sqlDate, sqlDate, 1234234, devAlice, websiteRoleList);
        webDAO.createWebsiteForDeveloper(devAlice.getId(), Facebook);

        websiteRoleList = new ArrayList<>();
        owner = new WebsiteRole("Twitter", "bob", "owner");
        editor = new WebsiteRole("Twitter", "charlie", "editor");
        admin = new WebsiteRole("Twitter", "alice", "admin");
        websiteRoleList.add(owner);
        websiteRoleList.add(editor);
        websiteRoleList.add(admin);
        Website Twitter = new Website(2, "Twitter", "an online news and social networking service", sqlDate, sqlDate, 4321543, devBob, websiteRoleList);
        webDAO.createWebsiteForDeveloper(devBob.getId(), Twitter);

        websiteRoleList = new ArrayList<>();
        owner = new WebsiteRole("Wikipedia", "charlie", "owner");
        editor = new WebsiteRole("Wikipedia", "alice", "editor");
        admin = new WebsiteRole("Wikipedia", "bob", "admin");
        websiteRoleList.add(owner);
        websiteRoleList.add(editor);
        websiteRoleList.add(admin);
        Website Wikipedia = new Website(3, "Wikipedia", "a free online encyclopedia", sqlDate, sqlDate, 3456654, devCharlie, websiteRoleList);
        webDAO.createWebsiteForDeveloper(devCharlie.getId(), Wikipedia);

        websiteRoleList = new ArrayList<>();
        owner = new WebsiteRole("CNN", "alice", "owner");
        editor = new WebsiteRole("CNN", "bob", "editor");
        admin = new WebsiteRole("CNN", "charlie", "admin");
        websiteRoleList.add(owner);
        websiteRoleList.add(editor);
        websiteRoleList.add(admin);
        Website CNN = new Website(4, "CNN", "an American basic cable and satellite television news channel", sqlDate, sqlDate, 6543345, devAlice, websiteRoleList);
        webDAO.createWebsiteForDeveloper(devAlice.getId(), CNN);

        websiteRoleList = new ArrayList<>();
        owner = new WebsiteRole("CNET", "bob", "owner");
        editor = new WebsiteRole("CNET", "charlie", "editor");
        admin = new WebsiteRole("CNET", "alice", "admin");
        websiteRoleList.add(owner);
        websiteRoleList.add(editor);
        websiteRoleList.add(admin);
        Website CNET = new Website(5, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", sqlDate, sqlDate, 5433455, devBob, websiteRoleList);
        webDAO.createWebsiteForDeveloper(devBob.getId(), CNET);

        websiteRoleList = new ArrayList<>();
        owner = new WebsiteRole("Gizmodo", "charlie", "owner");
        editor = new WebsiteRole("Gizmodo", "alice", "editor");
        admin = new WebsiteRole("Gizmodo", "bob", "admin");
        websiteRoleList.add(owner);
        websiteRoleList.add(editor);
        websiteRoleList.add(admin);
        Website Gizmodo = new Website(6, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics", sqlDate, sqlDate, 4322345, devCharlie, websiteRoleList);
        webDAO.createWebsiteForDeveloper(devBob.getId(), Gizmodo);

        List<PageRole> pageRoleList = new ArrayList<>();
        PageRole editorP = new PageRole("Home","alice","editor");
        PageRole reviewer = new PageRole("Home", "bob", "reviewer");
        PageRole writer = new PageRole("Home", "charlie", "writer");
        pageRoleList.add(editorP);
        pageRoleList.add(reviewer);
        pageRoleList.add(writer);
        Page Home = new Page(1, "Home", "Landing Page", date1, date2, 123434, CNET, pageRoleList);
        pageDAO.createPageForWebsite(CNET.getId(), Home);

        pageRoleList = new ArrayList<>();
        editorP = new PageRole("About","bob","editor");
        reviewer = new PageRole("About", "charlie", "reviewer");
        writer = new PageRole("About", "alice", "writer");
        pageRoleList.add(editorP);
        pageRoleList.add(reviewer);
        pageRoleList.add(writer);
        Page About = new Page(2, "About", "Website description", date1, date2, 234545, Gizmodo, pageRoleList);
        pageDAO.createPageForWebsite(Gizmodo.getId(), About);

        pageRoleList = new ArrayList<>();
        editorP = new PageRole("Contact","charlie","editor");
        reviewer = new PageRole("Contact", "alice", "reviewer");
        writer = new PageRole("Contact", "bob", "writer");
        pageRoleList.add(editorP);
        pageRoleList.add(reviewer);
        pageRoleList.add(writer);
        Page Contact = new Page(3, "Contact", "Addresses, phones, and contact info", date1, date2, 345656, Wikipedia, pageRoleList);
        pageDAO.createPageForWebsite(Wikipedia.getId(), Contact);

        pageRoleList = new ArrayList<>();
        editorP = new PageRole("Preferences","alice","editor");
        reviewer = new PageRole("Preferences", "bob", "reviewer");
        writer = new PageRole("Preferences", "charlie", "writer");
        pageRoleList.add(editorP);
        pageRoleList.add(reviewer);
        pageRoleList.add(writer);
        Page Preferences = new Page(4, "Preferences", "Where users can configure their preferences", date1, date2, 456776, CNN, pageRoleList);
        pageDAO.createPageForWebsite(CNN.getId(), Preferences);

        pageRoleList = new ArrayList<>();
        editorP = new PageRole("Profile","bob","editor");
        reviewer = new PageRole("Profile", "charlie", "reviewer");
        writer = new PageRole("Profile", "alice", "writer");
        pageRoleList.add(editorP);
        pageRoleList.add(reviewer);
        pageRoleList.add(writer);
        Page Profile = new Page(5, "Profile", "Users can configure their personal information", date1, date2, 567878, CNET, pageRoleList);
        pageDAO.createPageForWebsite(CNET.getId(), Profile);

        Widget head123 = new Widget(1, "head123", 0, 0, null, null, "welcome", 0, null, false, false, null, null, Home,"heading");
        widgetDAO.createWidgetForPage(Home.getId(), head123);

        Widget post234 = new Widget(2, "post234", 0, 0, null, null, "<p>Lorem</p>", 0, null, false, false, null, null, About,"html");
        widgetDAO.createWidgetForPage(About.getId(), post234);

        Widget head345 = new Widget(3, "head345", 0, 0, null, null, "Hi", 1, null, false, false, null, null, Contact,"heading");
        widgetDAO.createWidgetForPage(Contact.getId(), head345);

        Widget intro456 = new Widget(4, "intro456", 0, 0, null, null, "<h1>Hi</h1>", 2, null, false, false, null, null, Contact,"html");
        widgetDAO.createWidgetForPage(Contact.getId(), intro456);

        Widget image345 = new Widget(5, "image345", 50, 100, null, null, null, 3, "/img/567.png", false, false, null, null, Contact,"image");
        widgetDAO.createWidgetForPage(Contact.getId(), image345);

        Widget video456 = new Widget(6, "video456", 400, 300, null, null, null, 0, "https://youtu.be/h67VX51QXiQ", false, false, null, null, Preferences,"youtube");
        widgetDAO.createWidgetForPage(Preferences.getId(), video456);

        // Update Queries
        developerDAO.changeNumber("charlie", "333-444-5555");
        widgetDAO.updateWidgetOrder(head345, 3);
        pageDAO.append(CNET, "CNET - ");
        roleDAO.swapRole("charlie", "bob" , "CNET", "CNET - Home");

        // Delete Queries
        developerDAO.deletePrimaryAddress("alice");
        widgetDAO.deleteLastWidget("Contact");
        pageDAO.removeLastUpdatedPage("Wikipedia");
        webDAO.deleteWebsiteByName("CNET");
    }
}
