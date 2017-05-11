package temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Iryna Tkachova on 30.03.2017.
 */

@EnableAutoConfiguration
@SpringBootApplication
public class Application  implements CommandLineRunner{

    @Autowired
    private SomeTableRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        do{
            Long temperature = Math.round((Math.random() * 80) - 40);
            Timestamp timestamp = new Timestamp(new Date().getTime());
            repository.save(new SomeTable(timestamp.toString(), temperature.toString()));
            Thread.sleep(10000);
        }while(true);
    }
}