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

3. dynamic人工管理服务上线和下线?

4. 服务分组怎么配置？使用场景是什么？https://dubbo.gitbooks.io/dubbo-user-book/demos/service-group.html

5. 分组聚合怎么使用？https://dubbo.gitbooks.io/dubbo-user-book/demos/group-merger.html

6. jsr303，https://dubbo.gitbooks.io/dubbo-user-book/demos/parameter-validation.html

7. cache, 缓存数据保存在哪儿？

8. 泛化引用、泛化实现，https://dubbo.gitbooks.io/dubbo-user-book/demos/generic-reference.html

9. 隐式参数未测试成功，https://dubbo.gitbooks.io/dubbo-user-book/demos/attachment.html

10. 本地调用未明白，https://dubbo.gitbooks.io/dubbo-user-book/demos/local-call.html

11. 怎么模拟一个RpcException? https://dubbo.gitbooks.io/dubbo-user-book/demos/local-mock.html

12. 通过‘并发控制’让provider返回RpcException，但并没有触发Mock，https://dubbo.gitbooks.io/dubbo-user-book/demos/concurrency-control.html

13. 粘滞链接未成功，https://dubbo.gitbooks.io/dubbo-user-book/demos/stickiness.html

14. xx
