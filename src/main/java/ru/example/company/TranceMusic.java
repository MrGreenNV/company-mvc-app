package ru.example.company;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TranceMusic implements Music {
    List<String> songList = new ArrayList<String>();
    {
        songList.add("Till the Sky");
        songList.add("Invisible touch");
        songList.add("You and I");
    }
    public String getSong() {
        Random random = new Random();
        return songList.get(random.nextInt(3));
    }
}
