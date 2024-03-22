package sit.example.int204springapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sit.example.int204springapi.properties.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Int204SpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Int204SpringApiApplication.class, args);
    }

}
