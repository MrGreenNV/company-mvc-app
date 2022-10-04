package ru.example.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    MusicPlayer player;

    @Autowired
    public Computer(MusicPlayer player) {
        this.id = 1;
        this.player = player;
    }

    public Computer() {
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", player=" + player.playMusic() +
                '}';
    }
}
