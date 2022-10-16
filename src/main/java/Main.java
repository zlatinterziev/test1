import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisURI;

public class Main {
    public static void main(String[] args) {

        RedisClient redisClient = new RedisClient(
                RedisURI.create("redis://redispw@localhost:49153"));
        var connection = redisClient.connect().sync();

        connection.ping();

        System.out.println("Connected to Redis");

        connection.set("foo", "bar");
        String value = connection.get("foo");

        connection.set("kur", "bar");

        System.out.println(value);
    }
}