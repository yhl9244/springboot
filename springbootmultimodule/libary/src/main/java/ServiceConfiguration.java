import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by suneee on 2018/6/13.
 */
@Configuration
@EnableConfigurationProperties(ServiceProperties.class)
public class ServiceConfiguration {

    @Bean
    public Service service(ServiceProperties serviceProperties){
        return new Service(serviceProperties.getMessage());
    }
}
