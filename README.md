# spring-boot-duboo-study

install zookeeper

    docker run --name zk --restart always -d -p 0.0.0.0:2181:2181 -p 0.0.0.0:2888:2888 -p 0.0.0.0:3888:3888 zookeeper

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
