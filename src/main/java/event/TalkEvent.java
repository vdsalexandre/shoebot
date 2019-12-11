package event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.Utils;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TalkEvent extends ListenerAdapter {
    public static final String DISCUSSION_CHANNEL_NAME = Utils.getProperty("app.discord.channel.discussion");
    public static final String GENERAL_CHANNEL_NAME = Utils.getProperty("app.discord.channel.general");
    public static final String DISCUSSION_BOT_SYMBOL = Utils.getProperty("app.discord.bot.discussionsymbol");
    private TextChannel discussionChannel = null, generalChannel = null;
    private SimpleDateFormat sdf;

    public TalkEvent() {
        this.sdf = new SimpleDateFormat("EEEE dd MMMM YYYY à HH:mm:ss");
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        initChannels(e);
        String messageReceived = e.getMessage().getContentRaw();
        String[] wordsReceived = messageReceived.split(" ");
        String currentChannelName = e.getChannel().getName();

        if (e.getAuthor().isBot()) return;

        if (messageReceived.startsWith(DISCUSSION_BOT_SYMBOL, 0)) {
            if (wordsReceived[0].contains("profile")) {
                EmbedBuilder embedMessageProfile = createEmbedMessageProfile(e);
                Utils.sendMessageToAnotherChannel(discussionChannel, embedMessageProfile.build());
            }

            if (!currentChannelName.equals(discussionChannel.getName())) {
                Utils.sendMessageToAnotherChannel(discussionChannel, messageReceived);
                Utils.deleteMessageFromChannel(e);
            }
        }
    }

//    public void sendUselessInformation() {
//        final Random random = new Random();
//        int timeToWait = random.nextInt(60) + 30;
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Utils.sendMessageToAnotherChannel(generalChannel, "");
////                timeToWait = random.nextInt(60) + 30;
//            }
//        }, 0, timeToWait * 1000);
//    }

    private EmbedBuilder createEmbedMessageProfile(GuildMessageReceivedEvent e) {
        EmbedBuilder embed = new EmbedBuilder();
        Member member = e.getGuild().getMembersByName(e.getAuthor().getName(), true).get(0);
        embed.setTitle("Profil utilisateur :");
        embed.setColor(Color.decode("#DB0073"));
        embed.addField("Nom d'utilisateur", member.getUser().getName(), true);
        embed.addField("ID", "#" + member.getId(), true);
        embed.addField("Online Status", member.getOnlineStatus().toString(), true);
        embed.addField("Rôle", member.getRoles().get(0).getName(), true);
        embed.setImage(member.getUser().getAvatarUrl());
        embed.setFooter("Requête effectuée le " + sdf.format(new Date()), e.getGuild().getIconUrl());
        return embed;
    }

    private void initChannels(GuildMessageReceivedEvent e) {
        if (discussionChannel == null)
            discussionChannel = e.getGuild().getTextChannelsByName(DISCUSSION_CHANNEL_NAME, true).get(0);

        if (generalChannel == null)
            generalChannel = e.getGuild().getTextChannelsByName(GENERAL_CHANNEL_NAME, true).get(0);
    }

}
