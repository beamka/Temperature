package temp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Iryna Tkachova on 30.03.2017.
 */
@Document
public class SomeTable {
    @Id
    private String timestamp;
    private String temperature;

    public SomeTable() {}

    public SomeTable(String timestamp, String temperature) {
        this.timestamp = timestamp;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return String.format("SomeTable[timestamp='%s', temperature='%s']", timestamp, temperature);
    }
    public String getTemperature() {
        return temperature;
    }
}