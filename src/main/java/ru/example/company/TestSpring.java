package ru.example.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Music music = context.getBean("classicalMusicBean", Music.class);
        Music music1 = context.getBean("rockMusicBean", Music.class);
        Music music2 = context.getBean("tranceMusicBean", Music.class);

        MusicPlayer player = new MusicPlayer(music);
        player.playMusic();

        player = new MusicPlayer(music1);
        player.playMusic();

        player = new MusicPlayer(music2);
        player.playMusic();

        context.close();
    }
}
