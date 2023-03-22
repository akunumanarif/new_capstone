APP_LIST ?= gateway-service, request-service, item-service, management-user-service, auth-service, chat-service
 
start : down remove up

down :
	docker compose -f docker-compose.yml down

remove :
	docker image rm -f ${APP_LIST}

up:
	docker compose -f docker-compose.yml up -d 

build:
	docker compose -f docker-compose.yml build

restart: down up
