import event.HelloEvent;
import event.RythmEvent;
import event.TalkEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import utils.Utils;

public class MainBot {
    public static void main(String args[]) throws Exception {
        String discordToken = Utils.getProperty("app.discord.bot.token");
        JDA jda = new JDABuilder(discordToken).build();
        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new RythmEvent());
        jda.addEventListener(new TalkEvent());
    }
}
