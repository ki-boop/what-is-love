#WHAT-IS-LOVE

# backend
### Запускаем [docker-compose](../docker-compose.yml):
 
```
docker-compose up -d --build
```
###Keycloak и база данных уже имеет тестовые данные

# front

### Переходим в директорию front
```
cd front
```
###После, скачиваем зависимости:
```
npm install
```

### Далее запускаем фронт часть проекта:
```
npm run serve
```
###Теперь заходим на localhost:8081
###Для авторизации нужен логин, пароль и роль, все логины и пароли лежат в [realm-export.json](../keycloak/realm-export.json)

###Вот пример одного из тестовых пользователей
```
    {
      "username": "manager_2",
      "email": "manager2@example.com",
      "firstName": "Марк",
      "lastName": "Нечаев",
      "enabled": true,
      "emailVerified": true,
      "credentials": [
        {
          "type": "password",
          "value": "123321"
        }
      ],
      "realmRoles": [
        "manager"
      ],
      "clientRoles": {
        "realm-management": []
      }
    }
```

