package pl.training.shop;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.training.commons.FastMoneyMapper;

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

}
