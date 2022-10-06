package ru.example.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class MusicPlayer {
    private List<Music> musicList = new ArrayList<Music>();
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

//    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music classicalMusic,
                       @Qualifier("rockMusic") Music rockMusic,
                       @Qualifier("tranceMusic") Music tranceMusic) {
        this.musicList.add(classicalMusic);
        this.musicList.add(rockMusic);
        this.musicList.add(tranceMusic);
    }

    public String playMusic(MusicGenre musicGenre) {

        switch (musicGenre) {
            case ROCK: {
                return musicList.get(1).getSong();
            }
            case CLASSICAL: {
                return musicList.get(0).getSong();
            }
            case TRANCE: {
                return musicList.get(2).getSong();
            }
            default: return null;
        }
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



//    public void playMusic() {
//        for (Music music: musicList) {
//            System.out.println("Playing: " + music.getSong());
//        }
//    }
}
