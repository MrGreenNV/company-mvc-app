package ru.example.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {
    private List<Music> musicList = new ArrayList<Music>();

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music classicalMusic,
                       @Qualifier("rockMusic") Music rockMusic,
                       @Qualifier("tranceMusic") Music tranceMusic) {
        this.musicList.add(classicalMusic);
        this.musicList.add(rockMusic);
        this.musicList.add(tranceMusic);
    }

//    public void setMusic(Music music) {
//        this.music = music;
//    }
//
//    //    List<Music> musicList = new ArrayList<Music>();
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getVolume() {
//        return volume;
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//    }
//
//    private int volume;
//
//    public MusicPlayer(Music music) {
//        this.music = music;
//    }
//
//    public MusicPlayer() {
//    }

//    public void setMusicList(List<Music> musicList) {
//        this.musicList = musicList;
//    }

    public String playMusic() {
        String s = "";

        for (Music music: musicList) {
            s += "// " +  music.getSong();
        }
        return s;
    }

//    public void playMusic() {
//        for (Music music: musicList) {
//            System.out.println("Playing: " + music.getSong());
//        }
//    }
}
