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