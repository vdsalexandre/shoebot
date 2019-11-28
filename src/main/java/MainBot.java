import event.HelloEvent;
import event.RythmEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class MainBot {
    public static void main(String args[]) throws Exception {
        JDA jda = new JDABuilder("NjQ5MzY4NDkxNDkyNzY5ODAy.Xd7yDA.tAbH7bzyHeBR6eL3R9v4u73eiGs").build();
        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new RythmEvent());
    }
}
