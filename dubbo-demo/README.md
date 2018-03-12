##Dubbo 2.6.0调研

#### 一、Dubbo 2.6.0变化
`该版本的更新主要是合并了当当网提供的 Dubbox 分支`

```
支持 REST（通过整合 resteasy）
高性能的序列化框架：kryo, FST
支持嵌入 Tomcat
```

为了保持原来的分支，同时作出以下小调整：

```
升级了一些依赖的版本：kryo、FST 和 Tomcat
删除了对核心 RPC 协议的变更以避免兼容性问题

```

`重要说明`

依赖关系：由于此版本中的所有新功能都是可选的，因此添加到此版本的依赖项不是可传递的(not transitive)，所以在使用新版本时不必担心引入任何依赖关系问题。反过来这意味着，只要决定使用此版本中的任何新功能，就必须将必要的依赖关系添加到项目中。

-------

#### 二、Dubbo使用示例:

*使用示例工程GIT地址*：https://github.com/iabcdata/dubbo-learning


##### 2.1  配置

2.1.1 暴露服务协议配置

```
    <dubbo:protocol name="dubbo" port="20881"/>
    <dubbo:protocol name="rest" port="${application.port}" contextpath="${application.contextpath}"
                    server="netty" threads="${application.concurrence}" accepts="${application.concurrence}"/>

```

配置项：
application.port=8088
application.concurrence=500
application.contextpath=demoa

2.1.2 服务暴露XML手动配置

***谨慎开启自动注解，避免相同服务既手动配置，又自动配置，若如此相同服务可能暴露多次***

```
<!--<dubbo:annotation package="io.iabc.dubbo.demoa.service"/>-->
<bean id="heyService" class="io.iabc.dubbo.demoa.service.stub.HeyServiceImpl"/>
    <dubbo:service interface="io.iabc.dubbo.demoa.share.service.HeyService" ref="heyService" protocol="dubbo,rest"/>
```
或者分开

```
<!--<dubbo:annotation package="io.iabc.dubbo.demoa.service"/>-->
<bean id="heyService" class="io.iabc.dubbo.demoa.service.stub.HeyServiceImpl"/>
    <dubbo:service interface="io.iabc.dubbo.demoa.share.service.HeyService" ref="heyService" protocol="dubbo"/>
    <dubbo:service interface="io.iabc.dubbo.demoa.share.service.HeyService" ref="heyService" protocol="rest"/>
```

2.1.3 使用注解自动配置

开启自动注解扫描

```
<dubbo:annotation package="io.iabc.dubbo.demoa.service"/>
```

2.1.4 使用kryo/fst序列化配置

kryo：

```
    <dubbo:protocol name="dubbo" port="20881" serialization="kryo"/>
    <dubbo:protocol name="rest" port="${application.port}" serialization="kryo" contextpath="${application.contextpath}"
                    server="netty" threads="${application.concurrence}" accepts="${application.concurrence}"/>
```

fst:

```
    <dubbo:protocol name="dubbo" port="20881" serialization="fst"/>
    <dubbo:protocol name="rest" port="${application.port}" serialization="fst" contextpath="${application.contextpath}"
                    server="netty" threads="${application.concurrence}" accepts="${application.concurrence}"/>
```

`优化建议:`
要让Kryo和FST完全发挥出高性能，最好将那些需要被序列化的类注册到dubbo系统中，例如，我们可以实现如下回调接口

```
public class SerializationOptimizerImpl implements SerializationOptimizer {

    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        classes.add(RequestBody.class);
        classes.add(ResponseBody.class);
        classes.add(Person.class);
        return classes;
    }
}
```

然后在配置中加上

kryo:

```
<dubbo:protocol name="dubbo" serialization="kryo" optimizer="io.iabc.dubbo.democ.service.network.SerializationOptimizerImpl"/>
<dubbo:protocol name="rest" port="${application.port}" serialization="kryo" optimizer="io.iabc.dubbo.demoa.service.network.SerializationOptimizerImpl contextpath="${application.contextpath}"
                    server="netty" threads="${application.concurrence}" accepts="${application.concurrence}"/>
```

fst:

```
<dubbo:protocol name="dubbo" serialization="fst" optimizer="io.iabc.dubbo.democ.service.network.SerializationOptimizerImpl"/>
<dubbo:protocol name="rest" port="${application.port}" serialization="fst" optimizer="io.iabc.dubbo.demoa.service.network.SerializationOptimizerImpl contextpath="${application.contextpath}"
                    server="netty" threads="${application.concurrence}" accepts="${application.concurrence}"/>
```

2.1.5 使用tomcat容器配置(需要增加tomcat版本依赖)

```
    <dubbo:protocol name="dubbo" port="20881"/>
    <dubbo:protocol name="rest" port="${application.port}" contextpath="${application.contextpath}"
                    server="tomcat" threads="${application.concurrence}" accepts="${application.concurrence}"/>
```

##### 2.2 类注解

`注解说明`
注解可以声明在接口中，也可以声明在实现中.
声明在接口中:标准写法，清晰，便于管理，虽然会在share包中会增加restesay的一点依赖
声明在实现中:share包依赖更加纯粹，但是维护成本会增加一点，虽然通过http方式可以正常调用，但是通过dubbo rest协议直连调用会提示找不到provider。

PS:`以下示例将注解声明在接口中`.

类注解示例:同时暴露rest和dubbo协议接口，并设置消费类型和生产类型，设置方法超时10秒

接口:

```java
@Path("hey")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public interface HeyService {
   ...
}
```

实现:
```java
@Service(protocol = { "rest", "dubbo" }, timeout = 10000)
public class HeyServiceImpl implements HeyService {

    @Resource(name = "userService")
    private UserInfoService userService; // 这里使用了guser服务
    
    ...
}
```
##### 2.3 GET方法注解

示例1:
接口:

```
    /**
     * 无参数状态校验接口(示例:curl -X GET -H "Content-Type: application/json" http://{IP}:{PORT}/demoa/hey/status)
     *
     * @return
     */
    @GET
    @Path("status")
    String status();
```
实现:

```
    @Override
    public String status() {
        System.out.println("ok");
        return "ok";
    }
```

示例2:

接口:

```
   /**
     * 根据请求参数获取用户信息接口(示例:curl -X GET -H "Content-Type: application/json" http://{IP}:{PORT}/demoa/hey/user?userId=13922)
     *
     * @param userId 用户ID
     * @return
     */
    @GET
    @Path("user")
    Object getUser(@QueryParam("userId") Long userId);
```

实现：

```
    @Override
    public Object getUser(Long userId) {

        ResponseDTO<UserInfoDTO> userInfoDTOResponseDTO = userService.getUserInfo(String.valueOf(userId));
        return userInfoDTOResponseDTO;
    }
```

示例3:

接口:

```
   /**
     * 根据请求参数获取用户信息接口(示例:curl -X GET -H "Content-Type: application/json" http://{IP}:{PORT}/demoa/hey/user/13922)
     *
     * @param userId 用户ID
     * @return
     */
    @GET
    @Path("user/{userId}")
    Object getUser2(@PathParam("userId") Long userId);
```

实现：

```
    @Override
    public Object getUser2(Long userId) {

        ResponseDTO<UserInfoDTO> userInfoDTOResponseDTO = userService.getUserInfo(String.valueOf(userId));
        return userInfoDTOResponseDTO;
    }
```




##### 2.4 POST方法注解
示例1:

接口:

```
   /**
     * 更新用户信息(示例:curl -X POST -H "Content-Type: application/json" http://{IP}:{PORT}/demoa/hey/user/query --data-ascii
     * '{"userId":13922,"name":"高山峰"}')
     *
     * @param userDTO
     * @return
     */
    @POST
    @Path("user/query")
    Object queryUser(UserDTO userDTO);
```

实现：

```
    @Override
    public Object queryUser(UserDTO userDTO) {
        System.out.println(JSON.toJSONString(userDTO));
        ResponseDTO<UserInfoDTO> userInfoDTOResponseDTO = userService.getUserInfo(String.valueOf(userDTO.getUserId()));
        return userInfoDTOResponseDTO;
    }
```

##### 2.5 PUT方法注解
示例1:

接口:

```
   /**
     * 更新用户信息(示例:curl -X PUT -H "Content-Type: application/json" http://{IP}:{PORT}/demoa/hey/user/update --data-ascii
     * '{"userId":13922,"name":"高山峰"}')
     *
     * @param userDTO
     * @return
     */
    @PUT
    @Path("user/update")
    Boolean updateUser(UserDTO userDTO);
```

实现：

```
    @Override
    public Boolean updateUser(UserDTO userDTO) {
        System.out.println(JSON.toJSONString(userDTO));
        return true;
    }
```

##### 2.6 DELETE方法注解
示例1:

接口:

```
   /**
     * 根据请求参数获取用户信息接口(示例:curl -X DELETE -H "Content-Type: application/json" http://{IP}:{PORT}/demoa/hey/user?userId=13922)
     *
     * @param userId 用户ID
     * @return
     */
    @DELETE
    @Path("user")
    Object delUser(@QueryParam("userId") Long userId);
```

实现：

```
    @Override
    public Object delUser(Long userId) {
        // Do Delete
        ResponseDTO<UserInfoDTO> userInfoDTOResponseDTO = userService.getUserInfo(String.valueOf(userId));
        return userInfoDTOResponseDTO;
    }
```

示例2:

接口:

```
   /**
     * 根据请求参数获取用户信息接口(示例:curl -X DELETE -H "Content-Type: application/json" http://{IP}:{PORT}/demoa/hey/user/13922)
     *
     * @param userId 用户ID
     * @return
     */
    @DELETE
    @Path("user/{userId}")
    Object delUser2(@PathParam("userId") Long userId);
```

实现：

```
    @Override
    public Object delUser2(Long userId) {
        // Do Delete
        ResponseDTO<UserInfoDTO> userInfoDTOResponseDTO = userService.getUserInfo(String.valueOf(userId));
        return userInfoDTOResponseDTO;
    }
```

-------


#### 三、兼容性
咨询了dubbo开发者小马哥，说dubbo 2.5.x 与dubbo 2.6.0互调兼容还在整合中，但是经过工程测试验证，2.4.*, dubbo 2.5.x 与dubbo 2.6.0互调是正常的，如示例工程中调用2.4.9版本的guser服务。但是和dubbox 2.8.4的工程是有问题的。

##### 3.1 与dubbox 2.8.4 互调时，编解码失败
##### 3.2 与dubbo 2.5.6 互调正常
##### 3.3 与dubbo 2.5.3 互调正常
##### 3.4 与dubbo 2.4.9 互调正常


-------


#### 四、升级建议

##### 4.1 经不完全测试，dubbo 2.4.* 和 2.5.* 可以平滑升级到2.6.0

##### 4.2 非核心应用服务建议将dubbo升级到2.6.0

##### 4.3 若需要提供restful风格http服务的应用，可以考虑升级到2.6.0


-------
升级后注意事项

```
1、 考虑到兼容旧版本,序列化方式不建议使用kryo/fst

2、 容器建议选择netty,根据个人喜好也可选择tomcat,但不建议使用jetty(dubbo中使用的是org.mortbay.jetty,而不是org.eclipse.jetty)

3、 dubbo服务暴露(Bean配置)，慎用服务自动扫描来注解服务，建议手工XML配置，便于统一维护和管理，以及一些参数控制，也便于后来接手者更易上手和维护。配置须谨慎，避免相同实例的相同协议的相同服务暴露多次，dubbo服务暴露未去重，虽不影响使用，但会引起不必要的误解。

4、 rest服务建议将注解放在服务接口声明处，避免服务使用dubbo rest协议直连时找不到provider

5、 多参数rest服务接口，尽量用POST传递整个请求对象；如果通过GET方式请求，一定要多参数，那么建议用PathParam，慎用QueryParam(第二个及以上的参数可能为null), 如果确实需要建议使用BeanParam

6、 查询(简单参数):GET
7、 查询(复杂参数):POST
8、 修改(非幂等):POST
9、 修改(幂等):PUT
10、 删除:DELETE
```








