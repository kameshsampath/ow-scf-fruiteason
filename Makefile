APP_VERSION:="0.0.1-SNAPSHOT"
SPRING_BOOT_VERSION:="1.5.9.RELEASE"
SPRING_CLOUD_FUNCTION_VERSION:="1.0.0.BUILD-SNAPSHOT"
FUNCTION_NAME:="fruiteason"

build:
	./mvnw clean install

.PHONY: docker
docker:
	docker build --rm \
	--build-arg APP_VERSION=$(APP_VERSION) \
	--build-arg SPRING_BOOT_VERSION=$(SPRING_BOOT_VERSION) \
	--build-arg SPRING_CLOUD_FUNCTION_VERSION=$(SPRING_CLOUD_FUNCTION_VERSION) \
	--build-arg FUNCTION_NAME=$(FUNCTION_NAME) \
	--tag kameshsampath/ow-scf-fruiteason .

.PHONY: docker-clean-all

clean: 
	-docker rmi kameshsampath/ow-scf-fruiteason ;\
	./mvnw clean

.PHONY: fn-create-fruiteason
fn-create-fruiteason:
	wsk -i action create fruiteason --docker kameshsampath/ow-scf-fruiteason

.PHONY: fn-update-fruiteason
fn-update-fruiteason:
	wsk -i action create fruiteason --docker kameshsampath/ow-scf-fruiteason


.PHONY: all-test
spring-test:
	wsk -i action invoke fruiteason -P src/test/all.json --result

.PHONY: summer-test
summer-test:
	wsk -i action invoke fruiteason -P src/test/summer.json --result

.PHONY: fall-test
fall-test:
	wsk -i action invoke fruiteason -P src/test/fall.json --result

.PHONY: winter-test
winter-test:
	wsk -i action invoke fruiteason -P src/test/winter.json --result

.PHONY: spring-test
spring-test:
	wsk -i action invoke fruiteason -P src/test/spring.json --result