package com.codeup.blog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiceController {

    @GetMapping("roll-dice")
    public String startPage(){
        return "dice";
    }

    @GetMapping("/roll-dice/{n}")
    public @ResponseBody String rollNum(@PathVariable int n) {
        int random = (int) Math.floor(Math.random() * 6) + 1;
        if (n == random) {
            return "That's correct! The dice landed on " + random + " and you guessed " + n + "!";
        } else {
            return "Wrong. The dice landed on " + random +", but you guessed " + n + ".";
        }
    }

}
