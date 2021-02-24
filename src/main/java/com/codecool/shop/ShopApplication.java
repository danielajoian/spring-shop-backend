package com.codecool.shop;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.User;
import com.codecool.shop.repository.ProductRepository;
import com.codecool.shop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository,
                                        UserRepository userRepository) {
        return args -> {
            userRepository.saveAll(Arrays.asList(
                User.builder()
                    .email("gigi@gigel.go")
                    .name("Gigi Gigescu")
                    .phone("0722343643")
                    .build(),
                User.builder()
                    .email("danut@dan.ro")
                    .name("Danut Diaconescu")
                    .phone("0744332212")
                    .build()
            ));


//            productRepository.saveAll(Arrays.asList(
//                Product.builder()
//                    .price(1000)
//                    .category(ProductCategory.ELECTRONICS)
//                    .title("iPhone XXL")
//                    .imageLink("https://i.pinimg.com/originals/15/a1/4b/15a14b04dd90345469551d06f36993e4.jpg")
//                    .description("Biggest iPhone yet")
//                    .user(userRepository.getOne((long) 1))
//                .build(),
//                Product.builder()
//                    .price(500_000)
//                    .category(ProductCategory.ESTATE)
//                    .title("Vila Brasov")
//                    .imageLink("https://cf.bstatic.com/images/hotel/max1024x768/178/17815433.jpg")
//                    .description("2000mp, curte mare, jacuzzi, piscina, sala sport proprie, balta pt pescuit")
//                    .user(userRepository.getOne((long) 2))
//                    .build(),
//                Product.builder()
//                        .price(500_000)
//                        .category(ProductCategory.ESTATE)
//                        .title("Vila Brasov")
//                        .imageLink("https://cf.bstatic.com/images/hotel/max1024x768/178/17815433.jpg")
//                        .description("2000mp, curte mare, jacuzzi, piscina, sala sport proprie, balta pt pescuit")
//                        .user(userRepository.getOne((long) 2))
//                        .build()
//            ));
        };
    }

}
