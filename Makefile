.PHONY: start
start:
	docker-compose up -d --force-recreate
	docker ps

.PHONY: stop
stop:
	docker-compose down
	docker ps
