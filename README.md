# smf-cache
spring boot 整合redis和ehcache并实现缓存过期设置
### 1、引入依赖
```
<!-- redis -->
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<!-- cache -->
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
<!-- ehcache -->
<dependency>
   <groupId>net.sf.ehcache</groupId>
   <artifactId>ehcache</artifactId>
</dependency>
```
### 2、配置ehcache
```
<?xml version="1.0" encoding="UTF-8"?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="ehcache.xsd">
    <!-- 测试 -->
    <cache name="myCache"
           eternal="false"
           timeToIdleSeconds="10"
           timeToLiveSeconds="20"
           maxEntriesLocalHeap="10000"
           maxEntriesLocalDisk="10000000"
           diskExpiryThreadIntervalSeconds="120"
    >
    </cache>
</ehcache>
```
### 3、application.properties配置
#### 指定缓存类型ehcache、redis等，禁用none
```
spring.cache.type=ehcache
```
#### ehcache配置
```
spring.cache.ehcache.config=classpath:ehcache.xml
```
#### redis配置
```
spring.redis.host=localhost
spring.redis.password=
spring.redis.port=6379
spring.redis.database=0
```
### 4、启动类添加注解：
```
@EnableCaching // 开始缓存功能
```
### 5、使用，@CacheConfig(cacheNames="myCache") 为全局配置，当缓存为ehcache时cacheNames=""必填且ehcache.xml中的缓存名称一致
```
//@CacheConfig(cacheNames="myCache")
@Service
public class CacheService {

    @Cacheable(value = "myCache",key="#p0")//#：取值方式    p:参数的意思parameter     0：下标
    public String  test1(Integer id) {
        System.out.println(id+"test1");
        return id.toString();
    }

    @Cacheable(value = "myCache",key="#id")
    public String  test2(Integer id) {
        System.out.println(id+"test2");
        return id.toString();
    }
    @Cacheable(value = "myCache",key="#id")
    public String  test3(Integer id) {
        System.out.println(id+"test3");
        return id.toString();
    }
}
```
