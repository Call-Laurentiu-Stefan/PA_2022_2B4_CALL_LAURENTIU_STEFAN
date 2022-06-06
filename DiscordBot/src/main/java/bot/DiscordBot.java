package bot;

import com.sun.syndication.io.FeedException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiscordBot extends ListenerAdapter {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault("OTgzMzA3Nzg4NDIxODM2ODUw.G1dy7d.pegvzLotyt61iKAFUKNeeiIHg_zMGzioAMjhZ0")
                .addEventListeners(new DiscordBot())
                .build();

    }

        public void onMessageReceived (MessageReceivedEvent event){
            if (event.getAuthor().isBot()) {
                return;
            } else {
                String message = event.getMessage().getContentDisplay();
                try {
                    filterByMessage(message, event);
                } catch (FeedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void filterByMessage (String message, MessageReceivedEvent event) throws FeedException {
            RssReader info = new RssReader();
            String informatie = info.getRss();
            Pattern patTitle = Pattern.compile("<title>([^<]*)");
            Matcher matchTitle = patTitle.matcher(informatie);
            ArrayList<String> titluri = new ArrayList<>();
            while (matchTitle.find()) {
                titluri.add(matchTitle.group(1));
            }

            Pattern patDesc = Pattern.compile("<description>([^<]*)");
            Matcher matchDesc = patDesc.matcher(informatie);
            ArrayList<String> descrieri = new ArrayList<>();
            while (matchDesc.find()) {
                descrieri.add(matchDesc.group(1));
            }

            Pattern patLink = Pattern.compile("<link>([^<]*)");
            Matcher matchLink = patLink.matcher(informatie);
            ArrayList<String> linkuri = new ArrayList<>();
            while (matchLink.find()) {
                linkuri.add(matchLink.group(1));
            }
            for (int i = 0; i < titluri.size(); i++) {
                if (titluri.get(i).contains(message.toLowerCase())) {
                    event.getChannel().sendMessage(descrieri.get(i)).queue();
                    event.getChannel().sendMessage("Daca doriti mai multe informatii accesati linkul " + linkuri.get(i)).queue();
                    break;
                }
            }
        }
 }
