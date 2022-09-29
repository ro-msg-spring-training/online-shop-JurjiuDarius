package ro.msg.training.shop.service;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@Data
public class StrategyConfiguration {
    private static LocationStrategy locationStrategy;
    private org.springframework.core.env.Environment env;

    StrategyConfiguration(Environment env) {
        this.env = env;
        String strategy = env.getProperty("locationStrategy");
        switch (strategy) {
            case "singleLocation": {
                locationStrategy = new SingleLocationStrategy();
                break;
            }
            case "mostAbundant": {
                locationStrategy = new MostAbundantStrategy();
                break;
            }
            default: {
                locationStrategy = new MostAbundantStrategy();
            }
        }
    }

    public static LocationStrategy getLocationStrategy() {
        return locationStrategy;
    }


}
