package ru.arkhipov.myfirsttestappspringboot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;

@RestController

public class HelloController {

    ArrayList<String> massiv = new ArrayList<String>();
    ArrayList<String> massivmapa = new ArrayList<String>();
    HashMap<Integer, String> mapa = new HashMap<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s", defaultValue = "") String s) {
        massiv.add(s);
        return String.format("Успешно добавлен элемент %s", s);
    }

    @GetMapping("/show-array")
    public String showArrayList(@RequestParam(value = "s", defaultValue = "") String s) {
        return massiv.toString();
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s", defaultValue = "") String s) {
        massivmapa.add(s);
        for(int i = 0; i < massivmapa.size(); ++i) {
            mapa.put(i, massivmapa.get(i));
        }
        return String.format("Успешно добавлен элемент %s", s);
    }

    @GetMapping("/show-map")
    public String showHashMap(@RequestParam(value = "s", defaultValue = "") String s) {
        return mapa.values().toString();
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght(@RequestParam(value = "s", defaultValue = "") String s) {
        return String.format("Количество элементов массива: %s; Количество элементов HashMap: %s",massiv.size(), mapa.size());
    }

}
