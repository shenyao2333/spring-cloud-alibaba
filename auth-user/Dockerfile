# 基础镜像使用java
FROM java:8
# 这里会在 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /data/docker
# 将jar包添加到容器中并更名为app.jar
ADD ./target/auth-user-0.0.1.jar auth-user-0.0.1.jar
EXPOSE 9012
ENTRYPOINT ["java", "-jar", "auth-user-0.0.1.jar"]
