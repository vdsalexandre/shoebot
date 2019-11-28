package event;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;


public class RythmEvent extends ListenerAdapter {
    public static final String MUSIC_CHANNEL_NAME = "musical";
    public static final String[] rythmKeyWords = {"!play", "!stop", "!resume", "!skip", "!disconnect", "!pause"};

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageReceived = event.getMessage().getContentRaw();
        String firstWord = event.getMessage().getContentRaw().split(" ")[0];
        User author = event.getAuthor();
        String currentChannel = event.getChannel().getName();

        if (author.isBot() && !MUSIC_CHANNEL_NAME.equals(currentChannel)) {
            System.out.println("Nouveau message de " + author.getName() + " envoyé vers #" + MUSIC_CHANNEL_NAME + " depuis #" + event.getChannel().getName() + " --> " + messageReceived);
            sendMusicMessageToMusicChannel(event, messageReceived);
        }

        if (Arrays.asList(rythmKeyWords).contains(firstWord) && !author.isBot() && MUSIC_CHANNEL_NAME != currentChannel) {
            System.out.println("Nouvelle commande lancée par [ " + author.getName() + " ] --> " + messageReceived);
            sendMusicMessageToMusicChannel(event, messageReceived);
        }
    }

    private void sendMusicMessageToMusicChannel(GuildMessageReceivedEvent event, String messageReceived) {
        TextChannel musicChannel = event.getGuild().getTextChannelsByName(MUSIC_CHANNEL_NAME, true).get(0);
        musicChannel.sendMessage(messageReceived).queue();
        event.getMessage().delete().complete();
    }
}
