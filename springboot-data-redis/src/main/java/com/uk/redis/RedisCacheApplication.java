package com.uk.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
* https://www.baeldung.com/spring-boot-redis-cache
* https://javatechonline.com/how-to-implement-redis-cache-in-spring-boot-application/
* https://dzone.com/articles/implementation-of-redis-in-micro-servicespring-boo
* https://stackoverflow.com/questions/41918560/redis-cluster-integration-with-spring-boot
* https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#cluster
* https://www.fullstack.cafe/blog/redis-interview-questions
* https://medium.com/@cosmicconvallis/interview-questions-on-redis-for-developers-c27769b410e9
* */


@SpringBootApplication
@EnableCaching
public class RedisCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }
}
