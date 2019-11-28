package event;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Arrays;

public class HelloEvent extends ListenerAdapter {
    public static final String[] helloAcceptedWords = {"hello", "salut", "bonjour", "bonsoir", "salutations"};
    public static final String BOT_NAME = "ChaussureBot";

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        try {
            String firstWord = event.getMessage().getContentRaw().split(" ")[0].toLowerCase();
            String secondWord = event.getMessage().getContentRaw().split(" ")[1];
            String user = event.getAuthor().getName();

            if (Arrays.asList(helloAcceptedWords).contains(firstWord) && BOT_NAME.equalsIgnoreCase(secondWord))
                event.getChannel().sendMessage("Salut " + user + " !").queue();

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Le message ne contient moins de deux mots ...");
        }
    }
}
