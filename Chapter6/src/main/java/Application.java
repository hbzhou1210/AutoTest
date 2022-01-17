import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication.*;


@SpringBootApplication
@ComponentScan("com.course,server")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
