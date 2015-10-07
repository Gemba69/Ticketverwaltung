
import com.hsw.model.real.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author jonas
 */
public class FakeDataProvider implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Project> projects = new ArrayList<>();
        Role admin = new Role("admin", "Administrator; darf Projekte erstellen.");
        Role member = new Role("member", "Mitglied; darf Tickets erstellen und zuweisen.");
        Status open = new Status("open", "Offen; Ticket noch in Bearbeitung.");
        Status closed = new Status("closed", "Geschlossen; Ticket erfolgreich abgeschlossen.");
        Status cancelled = new Status("cancelled", "Ticket wurde nicht gelöst, aber geschlossen.");
        User jonas = new User("jonas", "undefined", "jonas.poeppelmann@gmail.com", "Jonas", "Pöppelmann");
        jonas.addRole(admin);
        jonas.addRole(member);
        User philipp = new User("philipp", "undefined", "hilipp@labunde.de", "Philipp", "Klabunde");
        Tag hashTagGay = new Tag("gay", "Für räudige Tickets");
        Ticket guiBug = new Ticket(0, "Fehler in der GUI", "Die GUI ist vollkommen fehlerhaft und scheiße.", philipp);
        guiBug.setTicketStatus(open);
        guiBug.getComments().add(new Comment("In der Tat, die GUI ist nicht besonders schön.", jonas));
        guiBug.setTicketIssuer(jonas);
        Ticket modelBug = new Ticket(1, "Fehler im Model", "Das Model ist verdammt gay, Benni!", jonas);
        modelBug.setTicketStatus(open);
        modelBug.getTags().add(hashTagGay);
        Project ticketSystem = new Project(0, "Ticketsystem", "Unser aktuelles Projekt. Rekursiv, nicht wahr?", jonas);
        ticketSystem.getTickets().add(guiBug);
        ticketSystem.getTickets().add(modelBug);
        projects.add(ticketSystem);
        sce.getServletContext().setAttribute("projectList", projects);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("user", new User("jonas", "asdf", "jonas.poeppelmann@gmail.com", "Jonas", "Pöppelmann"));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println(event.getName());
        System.out.println(event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    }
}
