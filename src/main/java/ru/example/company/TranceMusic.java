package ru.example.company;

import org.springframework.stereotype.Component;

//@Component
public class TranceMusic implements Music {
    public String getSong() {
        return "Till the Sky";
    }
}
