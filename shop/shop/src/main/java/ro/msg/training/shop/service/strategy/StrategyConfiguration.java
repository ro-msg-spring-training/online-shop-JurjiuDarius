package ro.msg.training.shop.service.strategy;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.training.shop.service.LocationStrategyEnum;

@Configuration
@Data
@RequiredArgsConstructor
public class StrategyConfiguration {
	
	@Value("${locationStrategy}")
	private String locationStrategyVariable;
	
	@Bean
	public LocationStrategy getLocationStrategy() {
		switch (LocationStrategyEnum.valueOf(locationStrategyVariable)) {
			case SINGLE_LOCATION: {
				return new SingleLocationStrategy();
			}
			case MOST_ABUNDANT: {
				return new MostAbundantStrategy();
			}
			default:
				return new MostAbundantStrategy();
		}
	}
	
}



