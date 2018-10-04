 pwd
 cd DTH
 if [ "$(docker ps -a |grep dthservice | wc -l)" -ne 0 ]; then docker rm -f $(docker ps -a |grep dthservice | 
 awk '{print $1}') ; fi
 if [ "$(docker images | grep dth | wc -l)" -ne 0 ]; then docker rmi -f $(docker images |grep dth | 
 awk '{print $3}') ; fi
 docker build -t dthimage:latest .
 docker images
 docker login
 docker tag dthimage:latest sarbjot012/dthservice:latest
 docker push sarbjot012/dthservice:latest
 docker images
