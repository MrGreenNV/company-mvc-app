package ru.example.company;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
//    private Music music;
    List<Music> musicList = new ArrayList<Music>();
    private String name;

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

    private int volume;

//    public MusicPlayer(Music music) {
//        this.music = music;
//    }

    public MusicPlayer() {
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic() {
        for (Music music: musicList) {
            System.out.println("Playing: " + music.getSong());
        }
    }
}
