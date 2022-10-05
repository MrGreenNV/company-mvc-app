package ru.example.company;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music {

    List<String> songList = new ArrayList<String>();
    {
        songList.add("Symphony №9");
        songList.add("Symphony №3");
        songList.add("Symphony №6");
    }
    public String getSong() {
        Random random = new Random();
        return songList.get(random.nextInt(3));
    }
}
