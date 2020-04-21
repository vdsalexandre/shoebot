package event;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Utils;

import java.util.Arrays;

public class RythmEvent extends ListenerAdapter {
    private static final Logger LOG = LogManager.getLogger(RythmEvent.class);
    public static final String MUSIC_CHANNEL_NAME = Utils.getProperty("app.discord.channel.music");
    public static final String[] rythmKeyWords = Utils.getProperties("app.discord.music.keywords");
    public static final String MUSIC_BOT_NAME = Utils.getProperty("app.discord.musicbot.name");

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageReceived = event.getMessage().getContentRaw();
        String firstWord = event.getMessage().getContentRaw().split(" ")[0];
        User author = event.getAuthor();
        String currentChannel = event.getChannel().getName();

        if (isMusicalBot(author.getName()) && !isMusicalChannel(currentChannel)) {
            LOG.info("Message de " + author.getName() + " envoyé vers #" + MUSIC_CHANNEL_NAME + " depuis #" + currentChannel + " --> " + messageReceived);
            System.out.println("Message de " + author.getName() + " envoyé vers #" + MUSIC_CHANNEL_NAME + " depuis #" + currentChannel + " --> " + messageReceived);
            sendMusicMessageToMusicChannel(event, messageReceived);
        }

        if (isMusicalCommand(firstWord) && !isMusicalBot(author.getName()) && !isMusicalChannel(currentChannel)) {
            System.out.println("Nouvelle commande lancée par [ " + author.getName() + " ] --> " + messageReceived);
            sendMusicMessageToMusicChannel(event, messageReceived);
        }
    }

    private void sendMusicMessageToMusicChannel(GuildMessageReceivedEvent event, String messageReceived) {
        TextChannel musicChannel = event.getGuild().getTextChannelsByName(MUSIC_CHANNEL_NAME, true).get(0);
        musicChannel.sendMessage(messageReceived).queue();
        event.getMessage().delete().complete();
    }

    private Boolean isMusicalCommand(String firstWord) {
        return Arrays.asList(rythmKeyWords).contains(firstWord);
    }

    private Boolean isMusicalBot(String currentAuthor) {
        return MUSIC_BOT_NAME.equals(currentAuthor);
    }

    private Boolean isMusicalChannel(String currentChannel) {
        return MUSIC_CHANNEL_NAME.equals(currentChannel);
    }
}
