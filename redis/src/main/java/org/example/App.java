package org.example;

import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;

public class App {
    public static void main(String[] args) {
        JedisClientConfig config = DefaultJedisClientConfig.builder()
                .password("te!@CtWbm%6Z5s")
                .build();
        Jedis jedis = new Jedis("192.168.0.110", 6379, config);
        jedis.connect();
        jedis.select(3);
        jedis.set("k", "v");
        jedis.close();
    }
}
