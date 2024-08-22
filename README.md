# Skate Shop Inventory
## Skateboard Shop Inventory Management Application written with Java Spring Framework

## To Run, Build the container with the provided Containerfile and run the container.

podman build -t java-spring-skate-shop-inventory:latest .

podman run -d -p <host-port>:8080 --name skate-shop-inv java-spring-skate-shop-invntory:latest

## To kill:

podman stop skate-shop-inv
