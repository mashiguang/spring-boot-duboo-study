# spring-boot-duboo-study

docker

    # run in docker
    cd provider
    mvn package && docker build -t dubbo-provider . && docker run -it dubbo-provider
    
docker-compose    
    
    # docker-compose
    # cd %parent%
    docker-compose up --build
    
    # 2 dubbo-provider
    docker-compose up --scale dubbo-provider=2
    
问题：
1. 使用docker部署provider时，该provider注册到zookeeper时使用的是docker内部的ip，未使用宿主机的ip，
导致consumer无法找到provider。（除非consumer也在同一docker环境下运行??）    