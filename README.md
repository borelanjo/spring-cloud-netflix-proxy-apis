# spring-cloud-netflix-proxy-apis
[Criando proxy de APIs com Spring cloud, Zuul e Eureka](https://wp.me/p5RSbg-kW)

## Pré requisito
- Maven 3
- Java 15

### Optional
- Docker e docker-compose

## Preparando ambiente

### Sem Docker
- ```cd spring-cloud-netflix-proxy-apis```
- ```mvn clean package```

### Com Docker
Execute o `build.sh` ou build as imagens docker manualmente.

Cada modulo tem o seu próprio `Dockerfile` e `build.sh` com o comando utilizado para buildar a imagem.
Caso vc esteja usando Windows e não queira usar o git bash, você pode abrir e rodar o conteudo de cada build.sh,
por exemplo o customers:
```
cd customers
docker build --rm -t borelanjo/customer-service:latest .
```


## Executando 
### Sem Docker
Service Discovery (Eureka)
- ```cd eureka```
- ```mvn spring-boot:run```

Proxy (Gateway)
- ```cd zuul```
- ```mvn spring-boot:run```

API de Customers
- ```cd customers```
- ```mvn spring-boot:run```

API de Products
- ```cd products```
- ```mvn spring-boot:run```

API de Sellers
- ```cd sellers```
- ```mvn spring-boot:run```

API de Stores
- ```cd stores```
- ```mvn spring-boot:run```

API de Suppliers
- ```cd suppliers```
- ```mvn spring-boot:run```

### Com Docker
```
docker-compose up -d
```

Acssando Eureka: http://localhost:8761
Instances currently registered with Eureka
```

Application	AMIs	Availability Zones	Status
CUSTOMERS	n/a (1)	(1)	UP (1) - 192.168.11.247:customers:8060
PRODUCTS	n/a (1)	(1)	UP (1) - 192.168.11.247:products:8070
ZUUL	      n/a (1)	(1)	UP (1) - 192.168.11.247:zuul:8080
```

## Acessando APIs

#### Diretamente
#### Sem Docker
- http://localhost:8070/products
- http://localhost:8060/customers
- http://localhost:8096/sellers
- http://localhost:8098/stores
- http://localhost:8097/suppliers
#### Com Docker
As portas das api não estão expostas no docker compose, então caso queria acessar elas diretamente terá que modificar o
docker compose, por exemplo o customer-service ficaria assim:

```
customer-service:
  image: 'borelanjo/customer-service:latest'
  networks:
    - borelanjo-network
  ports:
    - "8060:8060"
  depends_on:
    - eureka-service
  environment:
    EUREKA_URL: customer-service
    EUREKA_DEFAULT_ZONE: 'http://eureka-service:8761/eureka'
```

#### Via Proxy (Gateway)
- http://localhost:8080/products
- http://localhost:8080/customers
- http://localhost:8080/sellers
- http://localhost:8080/stores
- http://localhost:8080/suppliers

O procedimento é o mesmo com ou sem docker

