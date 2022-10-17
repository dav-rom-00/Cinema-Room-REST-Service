package cinema.controller;

import cinema.exceptions.WrongPasswordException;
import cinema.model.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {
    private Stats stats;

    @Autowired
    public StatsController(Stats stats) {
        this.stats = stats;
    }

    @PostMapping("/stats")
    public Stats getStats(@RequestParam(required = false) String password) {

        if (password == null || !password.equals("super_secret")) {
            throw new WrongPasswordException("The password is wrong!");
        }

        stats.getStats();
        return stats;
    }
}
