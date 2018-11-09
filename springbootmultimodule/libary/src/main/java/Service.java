import org.springframework.stereotype.Component;

/**
 * Created by suneee on 2018/6/13.
 */
@Component
public class Service {

    private final String message;

    public Service(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
