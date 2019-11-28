package event;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.Utils;

import java.util.Arrays;

public class HelloEvent extends ListenerAdapter {
    public static final String[] helloAcceptedWords = Utils.getProperties("app.discord.hello.keywords");
    public static final String BOT_NAME = Utils.getProperty("app.discord.bot.name");

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        try {
            String firstWord = event.getMessage().getContentRaw().split(" ")[0].toLowerCase();
            String secondWord = event.getMessage().getContentRaw().split(" ")[1];
            String user = event.getAuthor().getName();

            if (isHelloWords(firstWord) && BOT_NAME.equalsIgnoreCase(secondWord))
                event.getChannel().sendMessage("Salut " + user + " !").queue();

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Le message contient moins de deux mots ...");
        }
    }

    private Boolean isHelloWords(String word) {
        return Arrays.asList(helloAcceptedWords).contains(word);
    }
}
