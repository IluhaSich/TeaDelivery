package com.example.teaDelivery.config;

import com.example.teaDelivery.entity.Basket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.KeyspaceConfiguration;
import org.springframework.data.redis.core.convert.MappingConfiguration;
import org.springframework.data.redis.core.index.IndexConfiguration;
import org.springframework.data.redis.core.mapping.RedisMappingContext;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.Collections;

@Configuration
@EnableRedisRepositories
//        (enableKeyspaceEvents = RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP)
public class RedisCfg {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName("localhost");
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }


//    @Bean
//    public RedisMappingContext keyValueMappingContext() {
//        return new RedisMappingContext(
//                new MappingConfiguration(new IndexConfiguration(), new CustomKeyspaceConfiguration()));
//    }

    public class CustomKeyspaceConfiguration extends KeyspaceConfiguration {

        @Override
        protected Iterable<KeyspaceSettings> initialConfiguration() {
            return Collections.singleton(customKeyspaceSettings(Basket.class, CacheName.KEY));
        }

        private <T> KeyspaceSettings customKeyspaceSettings(Class<T> type, String keyspace) {
            final KeyspaceSettings keyspaceSettings = new KeyspaceSettings(type, keyspace);
            keyspaceSettings.setTimeToLive((long) (5*60));
            return keyspaceSettings;
        }
    }

//    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CacheName {
        public static final String KEY = "Basket";
    }
}
