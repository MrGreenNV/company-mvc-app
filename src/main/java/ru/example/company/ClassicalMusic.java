package ru.example.company;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassicalMusic implements Music {

    @PostConstruct
    public void doMyInit() {
        System.out.println("init");
        songList.add("Symphony №9");
        songList.add("Symphony №3");
        songList.add("Symphony №6");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("destroy");
    }

    List<String> songList = new ArrayList<String>();

    public String getSong() {
        Random random = new Random();
        return songList.get(random.nextInt(3));
    }
}
