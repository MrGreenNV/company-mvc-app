package ru.example.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RockMusic implements Music {
    List<String> songList = new ArrayList<String>();
    {
        songList.add("We will rock you");
        songList.add("Nobody ");
        songList.add("Sid and Nancy");
    }
    public String getSong() {
        Random random = new Random();
        return songList.get(random.nextInt(3));
    }
}
