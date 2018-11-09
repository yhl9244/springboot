import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by suneee on 2018/6/13.
 */
@ConfigurationProperties("service")
public class ServiceProperties {

    /**
     * A message for the service.
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
