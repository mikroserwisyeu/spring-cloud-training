package pl.training.shop;

import org.mapstruct.factory.Mappers;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import pl.training.commons.FastMoneyMapper;

@EnableFeignClients
@EnableTransactionManagement
@Configuration
public class ShopConfiguration {

    @Bean
    public FastMoneyMapper fastMoneyMapper() {
        return Mappers.getMapper(FastMoneyMapper.class);
    }

   /* @Bean
    public Docket docket() {
        return new Docket(OAS_30)
                .select()
                .apis(withClassAnnotation(RestController.class))
                .build();
    }*/

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
