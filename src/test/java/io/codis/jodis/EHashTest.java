package io.codis.jodis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.ArrayList;
import java.util.List;

/**
 * created by bert on 2019/4/26.
 */
public class EHashTest {

    private Jedis jedis;

    @Before
    public void setup(){

        String zk = "192.168.60.48:2181";


        JedisResourcePool jodisPool = RoundRobinJedisPool.create().curatorClient(zk, 5000)
                .password("xmly123456")
                .zkProxyDir("/zk/codis/db_codis-ehash/proxy").build();

        jedis = jodisPool.getResource();

    }

    @Test
    public void ehscan() {


        System.out.println(jedis.ehkeys("hello"));

        List<String> list = new ArrayList<>();
        ScanParams params = new ScanParams();
        params.match("eh*");
        params.count(10);
        String cursor = "0";
        while (true) {
            ScanResult scanResult = jedis.ehscan("hello", cursor, params);
            List<String> elements = scanResult.getResult();
            if (elements != null && elements.size() > 0) {
                list.addAll(elements);
            }
            cursor = scanResult.getCursor();
            System.out.println("cursor ==> " + cursor);
            if ("0".equals(cursor)) {
                break;
            }
        }
        System.out.println(list);

    }
}


