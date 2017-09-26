package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    Sender sender;

    @RequestMapping("/")
    public String home() {
        sender.send("helloworld.t","hello");
        return "Hello Docker World";

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
