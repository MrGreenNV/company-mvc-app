package ru.example.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
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
        return classicalMusic.getSong();
    }

//    public void playMusic() {
//        for (Music music: musicList) {
//            System.out.println("Playing: " + music.getSong());
//        }
//    }
}
