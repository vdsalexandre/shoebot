import event.HelloEvent;
import event.RythmEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import utils.Utils;

public class MainBot {
    public static void main(String args[]) throws Exception {
        Utils u = new Utils();
        String discordToken = u.getApplicationPropertyValue("app.discord.token");
        JDA jda = new JDABuilder(discordToken).build();
        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new RythmEvent());
    }
}
