FROM frolvlad/alpine-oraclejdk8:slim
ENTRYPOINT [ "java", \
  "-jar", "/certbot-validator.jar", \
  "--server.port=8080" \
  ]
EXPOSE 8080
ADD build/libs/certbot-validator.jar certbot-validator.jar
