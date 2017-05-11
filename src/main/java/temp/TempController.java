package temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Iryna Tkachova on 30.03.2017.
 */

@RestController
public class TempController {

    @Autowired
    private SomeTableRepository repository;

    @RequestMapping(path = "/run",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Long run() {

        Timestamp curent_time = new Timestamp(new Date().getTime());
        Timestamp minus_hour = new Timestamp(curent_time.getTime()-3600000);

        Long count = 0L;
        Long buff = 0L;
        for (SomeTable someTable : repository.findByTimestampGreaterThan(minus_hour.toString())) {
            Long temperature = Long.parseLong(someTable.getTemperature(), 10);
            buff = buff + temperature;
            count++;
        }
        return buff/count;
    }
}