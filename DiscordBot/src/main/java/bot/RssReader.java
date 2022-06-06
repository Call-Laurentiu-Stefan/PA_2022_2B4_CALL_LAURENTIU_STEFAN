package bot;

import com.sun.syndication.feed.synd.*;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RssReader {


    SyndFeed feed = new SyndFeedImpl();

    public RssReader() {
        feed.setFeedType("rss_1.0");
        feed.setTitle("Wikipedia");
        feed.setLink("https://ro.wikipedia.org/");
        feed.setDescription("Pagina de start wikipedia");

        SyndEntry entryGrafConex = new SyndEntryImpl();
        entryGrafConex.setTitle("graf conex");
        entryGrafConex.setLink("https://ro.wikipedia.org/wiki/Conexitate_(teoria_grafurilor)");

        SyndEntry entryDrumEulerian = new SyndEntryImpl();
        entryDrumEulerian.setTitle("drum eurelian");
        entryDrumEulerian.setLink("https://ro.wikipedia.org/wiki/Drum_eulerian");

        SyndEntry entryDrumHamiltonian = new SyndEntryImpl();
        entryDrumHamiltonian.setTitle("drum hamiltonian");
        entryDrumHamiltonian.setLink("https://ro.wikipedia.org/wiki/Drum_hamiltonian");

        SyndEntry entryGrafOrientat = new SyndEntryImpl();
        entryGrafOrientat.setTitle("graf orientat");
        entryGrafOrientat.setLink("https://ro.wikipedia.org/wiki/Graf_orientat");

        SyndEntry entryGraf = new SyndEntryImpl();
        entryGraf.setTitle("graf");
        entryGraf.setLink("https://ro.wikipedia.org/wiki/Graf");

        feed.setEntries(Arrays.asList(entryGraf, entryGrafConex, entryDrumEulerian, entryDrumHamiltonian, entryGrafOrientat));


        SyndContent descriptionGrafConex = new SyndContentImpl();
        descriptionGrafConex.setType("text/html");
        descriptionGrafConex.setValue("Gradul de conexitate este numărul minim de elemente (noduri sau muchii)" +
                " care trebuie eliminate pentru a separa nodurile rămase în două sau mai multe subgrafuri izolate.");

        SyndContent descriptionDrumHamiltonian = new SyndContentImpl();
        descriptionDrumHamiltonian.setType("text/html");
        descriptionDrumHamiltonian.setValue("În domeniul matematic al teoriei grafurilor, un drum hamiltonian este un drum " +
                "într-un graf neorientat sau orientat care vizitează fiecare nod o singură dată.");

        SyndContent descriptionGrafOrientat = new SyndContentImpl();
        descriptionGrafOrientat.setType("text/html");
        descriptionGrafOrientat.setValue("Un graf orientat (sau digraf) este un graf ale cărui muchii au asociat un sens.");

        SyndContent descriptionDrumEulerian = new SyndContentImpl();
        descriptionDrumEulerian.setType("text/html");
        descriptionDrumEulerian.setValue("Un drum eulerian (sau lanț eulerian) este un drum într-un graf finit," +
                " care vizitează fiecare muchie exact o dată.");

        SyndContent descriptionGraf = new SyndContentImpl();
        descriptionGraf.setType("text/html");
        descriptionGraf.setValue("un graf este o structură care corespunde unui grup de obiecte, " +
                "în care unele perechi de obiecte sunt într-un anumit sens legate reciproc. " +
                "Obiectele corespund unor abstracții matematice numite într-un graf noduri/vârfuri (" +
                "numite și puncte) și fiecare legătură dintre perechile de obiecte asociate se numește muchie.");

        entryGrafConex.setDescription(descriptionGrafConex);
        entryDrumHamiltonian.setDescription(descriptionDrumHamiltonian);
        entryGrafOrientat.setDescription(descriptionGrafOrientat);
        entryDrumEulerian.setDescription(descriptionDrumEulerian);
        entryGraf.setDescription(descriptionGraf);

        List<SyndCategory> teoriaGrafurilor = new ArrayList<>();
        SyndCategory category = new SyndCategoryImpl();
        category.setName("Teoria grafurilor");
        teoriaGrafurilor.add(category);

        entryGrafConex.setCategories(teoriaGrafurilor);
        entryDrumHamiltonian.setCategories(teoriaGrafurilor);
        entryGrafOrientat.setCategories(teoriaGrafurilor);
        entryDrumEulerian.setCategories(teoriaGrafurilor);
        entryGraf.setCategories(teoriaGrafurilor);
    }

    public String getRss() throws FeedException {
            SyndFeedOutput syndFeedOutput = new SyndFeedOutput();
            return syndFeedOutput.outputString(feed);
        }

}
