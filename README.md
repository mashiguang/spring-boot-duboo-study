# spring-boot-duboo-study

install zookeeper

    docker run --name zk --restart always -d -p 0.0.0.0:2181:2181 -p 0.0.0.0:2888:2888 -p 0.0.0.0:3888:3888 zookeeper

install redis

    docker run --name nd-redis  --restart always -d -p 0.0.0.0:6379:6379 redis

docker

    # run provider in docker
    cd provider
    mvn package && docker build -t dubbo-provider . && docker run -it dubbo-provider
    
    # run consumer in docker
    cd consumer
    mvn package && docker build -t dubbo-consumer . && docker run -it dubbo-consumer
    
docker-compose    
    
    # docker-compose
    # cd %parent%
    docker-compose up --build
    or
    mvn clean package && docker-compose up --build
    
    # 2 dubbo-provider
    docker-compose up --scale dubbo-provider=2
    
    # 3 dubbo-provider, 10 dubbo-consumer
    docker-compose up --scale dubbo-provider=3 --scale dubbo-consumer=10

问题：
1. 使用docker部署provider时，该provider注册到zookeeper时使用的是docker内部的ip，未使用宿主机的ip，
导致consumer无法找到provider。（除非consumer也在同一docker环境下运行??）    

2. 文档中说的forks，未测试成功，https://dubbo.gitbooks.io/dubbo-user-book/demos/fault-tolerent-strategy.html

3. dynamic=false, 人工管理服务上线和下线. 在哪儿管理？在注册中心管理吗？ https://dubbo.gitbooks.io/dubbo-user-book/demos/static-service.html

4. 服务分组怎么配置？使用场景是什么？https://dubbo.gitbooks.io/dubbo-user-book/demos/service-group.html

        指定分组测试通过，假设provider端有foo, bar 两个分组，consumer 端可以指定使用某一组。
        但是使用group='*'，并不能随机转换分组，而是固定使用bar 这个分组，这是为什么？

5. _-已测试通过-, 分组聚合怎么使用？https://dubbo.gitbooks.io/dubbo-user-book/demos/group-merger.html_

6. _-无需测试-jsr303，https://dubbo.gitbooks.io/dubbo-user-book/demos/parameter-validation.html_

7. cache, 缓存数据保存在哪儿？https://dubbo.gitbooks.io/dubbo-user-book/demos/result-cache.html

8. 泛化引用、泛化实现，https://dubbo.gitbooks.io/dubbo-user-book/demos/generic-reference.html

9. _-隐式参数已测试成功-，https://dubbo.gitbooks.io/dubbo-user-book/demos/attachment.html_

10. _本地调用已测试，https://dubbo.gitbooks.io/dubbo-user-book/demos/local-call.html_

        本地调用使用了 injvm 协议，是一个伪协议，它不开启端口，不发起远程调用，
        只在 JVM 内直接关联，但执行 Dubbo 的 Filter 链。

11. 怎么模拟一个RpcException? https://dubbo.gitbooks.io/dubbo-user-book/demos/local-mock.html

12. 通过‘并发控制’让provider返回RpcException，但并没有触发Mock，https://dubbo.gitbooks.io/dubbo-user-book/demos/concurrency-control.html

13. 粘滞链接未成功，https://dubbo.gitbooks.io/dubbo-user-book/demos/stickiness.html

14. 路由规则未成功，https://dubbo.gitbooks.io/dubbo-user-book/demos/routing-rule.html

15. 规则配置未测试，https://dubbo.gitbooks.io/dubbo-user-book/demos/config-rule.html

16. 服务降级未测试，https://dubbo.gitbooks.io/dubbo-user-book/demos/service-downgrade.html

17. 主机绑定未测试，https://dubbo.gitbooks.io/dubbo-user-book/demos/hostname-binding.html

18. 服务容器未测试，https://dubbo.gitbooks.io/dubbo-user-book/demos/service-container.html

19. reference config 缓存，https://dubbo.gitbooks.io/dubbo-user-book/demos/reference-config-cache.html

20. netty, https://dubbo.gitbooks.io/dubbo-user-book/demos/dump.html

21. 为什么provider里的第2个org.springframework.boot.CommandLineRunner不执行呢

        provider里可以运行多个runner，通过@Order 控制各个runner 的执行顺序，数值越小运行的超早。
        之前未测试成功，是因为执行早的那个runner 里有一句**Thread.currentThread().join();** 导致后面的runner没有机会执行。

22. x
