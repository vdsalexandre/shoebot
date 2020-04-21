import event.HelloEvent;
import event.RythmEvent;
import event.TalkEvent;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import utils.Utils;

public class MainBot {
    public static void main(String args[]) throws Exception {
        String token = Utils.getProperty("app.discord.bot.token");
        JDA jda = JDABuilder.createDefault(token).build();

//        jda.addEventListener(new HelloEvent());
//        jda.addEventListener(new RythmEvent());
//        jda.addEventListener(new TalkEvent());
    }
}
