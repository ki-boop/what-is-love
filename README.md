#WHAT-IS-LOVE

# backend
Для поднятия бэкенда, keycloak, postgresql:
 
```
docker-compose up -d --build
```

###Keycloak и postgresql [уже имеет тестовые данные](back/src/main/resources/db/migration)

# front

Для запуска:
```
cd front
npm install
npm run serve
```
Доступен на localhost:8081

Тестовые аккаунты уже импортированы в keycloak realm: [realm-export.json](keycloak/realm-export.json)

usernames: customer_1, customer_2, manager_1, manager_2, manager_3, manager_4
passwords: 123321

Пример одного из тестовых пользователей:
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

