# NextGen

### Integrantes:
- Felipe Cardoso Torlai - RM: 550263
- Felipe Santos Pinheiro - RM: 550244
- Gabriel Girami de Souza - RM: 98017
- Gustavo Vinhola dos Santos - RM: 98826
- Jean Carlos Oliveira Silva - RM: 550430

## Pré-requisitos

- JDK Instalado: Clique aqui para instalar
- Visual Studio Code instalado.

### Instalando as extensões necessárias

1. Vá nas extensões do Visual Studio Code ou digite:
```
    Ctrl + Shift + X
```
2. Digite na barra de pesquisa: 
```
    Spring Boot Extension Pack
```
3. Clique em "Install" ou "Instalar".

<img src="src/images/Spring Boot Extension Picture.png" height="100" title="nome imagem">

<br/>

## Imagem dos diagramas

### Diagrama dos domínios da aplicação
#### Para ver melhor o diagrama, acesse <a href="https://lucid.app/lucidchart/a0fc1580-7050-44fe-aded-730dcba88d91/edit?viewport_loc=526%2C467%2C4267%2C1982%2CHWEp-vi-RSFO&invitationId=inv_3ceb64c0-1371-4540-99c9-09216c3434c0">aqui</a>

#### Para ver uma explicação resumida do diagrama, clique <a href="https://youtu.be/pTT5xAGuAkY">aqui</a>

<img src="src/images/NextGen Project.png">

### Diagrama Entidade-Relacionamento

<img src="src/images/NextGen DER.png">


## Proposta para a Plusoft

#### Clique <a href="https://youtu.be/wQaMeada2r0">aqui</a> para acessar o vídeo da nossa proposta para a Plusoft


## Recursos

- [ ] CRUD de Usuários
- [ ] CRUD de Feedbacks
- [ ] CRUD de Empresas

## Documentação

### Endpoints

- [Método Listar](#método-listar)
- [Método Cadastrar](#método-cadastrar)
- [Método Detalhar](#método-detalhar)
- [Método Apagar](#método-apagar)
- [Método Atualizar](#método-atualizar)

### Método Listar


- Listar Usuário


    `GET` /users

    Retorna um Array com todos os atributos do user

    #### Exemplo de resposta

    ```js
    [
        {
            "id": 1,
            "name": "Pedro",
            "registrationDate": "2023-04-01",
            "gender": "Masculine",
            "aged": "false",
            "timeOfService": "18",
            "exitForecast": "2025-06-13"
        }
    ]
    ```

    Obs: O atributo "timeOfService" é medido em meses


    #### Códigos de resposta

    |código| descrição|
    |------|----------|
    |200| Usuário retornado com sucesso
    |401| Usuário não autorizado. Realize a autenticação em /login 
    <br/>


-  Listar Feedback

    
    `GET` /feedbacks

    Retorna um Array com todos os atributos do feedback

    #### Exemplo de resposta

    ```js
    [
        {
            "id": 1,
            "user": "Pedro",
            "feeling": "Regular",
            "date": "2023-07-25",
            "company": "Microsoft"
        }
    ]
    ```

    #### Códigos de resposta

    |código| descrição|
    |------|----------|
    |200| Feedback retornado com sucesso
    |401| Feedback não autorizado. Realize a autenticação em /login 
    <br/>


-  Listar Empresas

    
    `GET` /companies

    Retorna um Array com todos os atributos da empresa

    #### Exemplo de resposta

    ```js
    [
        {
            "id": 1,
            "name": "Microsoft",
            "registrationDate": "2023-10-02",
            "numberOfFeedbacks": "1",
            "branch": "Omni CRM"
        }
    ]
    ```

    #### Códigos de resposta

    |código| descrição|
    |------|----------|
    |200| Empresa retornada com sucesso
    |401| Empresa não autorizada. Realize a autenticação em /login 
    <br/>

### Método Cadastrar

- Cadastrar Usuário


    `POST` /users

    Cadastro de um usuário com o corpo de uma requisição

    #### Corpo da requisição

    |campo|tipo|obrigatório|descrição|
    |-----|----|:-----------:|---------|
    |name|string|✅|Nome do usuário matriculado
    |registrationDate|localdate|✅|Data de cadastro do usuário
    |isSatisfied|boolean|✅|Satisfação do usuário
    |gender|string|✅|Gênero do usuário
    |aged|boolean|✅|Verificar se o usuário é idoso
    |timeOfService|bigdecimal|✅|Tempo de serviço em meses
    |exitForecast|localdate|✅|Previsão de saída

    ```js
    {
        "name": "Pedro",
        "registrationDate": "2023-04-01",
        "gender": "Masculine",
        "aged": "false",
        "timeOfService": "18",
        "exitForecast": "2025-06-13"
    }
    ```

    #### Exemplo da resposta

    ```js
    {
        "id": "1",
        "name": "Pedro",
        "registrationDate": "2023-04-01",
        "gender": "Masculine",
        "aged": "false",
        "timeOfService": "18",
        "exitForecast": "2025-06-13"
    }
    ```

    #### Códigos de Resposta

    |código|descrição|
    |------|---------|
    |200| Usuário cadastrado com sucesso
    |400| Validação falhou. Verifique os dados enviados no corpo da requisição
    |401| Não autorizado. Realize a autenticação em /login
    <br/>

- Cadastrar Feedback

    `POST` /feedbacks

    Cadastro de um feedback com o corpo de uma requisição

    #### Corpo da requisição

    |campo|tipo|obrigatório|descrição|
    |-----|----|:-----------:|---------|
    |user|string|✅|Nome do usuário que fez o feedback
    |feeling|enum|✅|Sentimento do dono do feedback
    |date|localdate|✅|Data de criação do feedback
    |company|string|✅|Empresa-alvo do feedback

    ```js
    {
        "user": "Pedro",
        "feeling": "Regular",
        "date": "2023-07-25",
        "company": "Microsoft"
    }
    ```

    #### Exemplo da resposta

    ```js
    {
        "id": 1,
        "user": "Pedro",
        "feeling": "Regular",
        "date": "2023-07-25",
        "company": "Microsoft"
    }
    ```

    #### Códigos de Resposta

    |código|descrição|
    |------|---------|
    |200| Feedback guardado com sucesso
    |400| Validação falhou. Verifique os dados enviados no corpo da requisição
    |401| Não autorizado. Realize a autenticação em /login
    <br/>


- Cadastrar Empresa

    `POST` /companies

    Cadastro de uma empresa com o corpo de uma requisição

    #### Corpo da requisição

    |campo|tipo|obrigatório|descrição|
    |-----|----|:-----------:|---------|
    |name|string|✅|Nome da empresa em cadastro
    |registrationDate|localdate|✅|Data de cadastro da empresa
    |numberOfFeedbacks|integer|✅|Número de feedbacks que a empresa contém
    |branch|string|✅|Ramo da Plusoft que a empresa está

    ```js
        {
            "name": "Microsoft",
            "registrationDate": "2023-10-02",
            "numberOfFeedbacks": "1",
            "branch": "Omni CRM"
        }
    ```

    #### Exemplo da resposta

    ```js
        {
            "id": "1",
            "name": "Microsoft",
            "registrationDate": "2023-10-02",
            "numberOfFeedbacks": "1",
            "branch": "Omni CRM"
        }
    ```

    #### Códigos de Resposta

    |código|descrição|
    |------|---------|
    |200| Empresa cadastrada com sucesso
    |400| Validação falhou. Verifique os dados enviados no corpo da requisição
    |401| Não autorizado. Realize a autenticação em /login
    <br/>


### Método Apagar

- Apagar usuário

    `DELETE` /users/`{id}`

    Apaga o usuário com o `id` informado no parâmetro de path.

    #### Códigos de Resposta

    |código|descrição|
    |------|---------|
    |201| Usuário apagado com sucesso
    |401| Não autorizado. Realize a autenticação em /login
    <br/>

- Apagar feedback

    `DELETE` /feedbacks/`{id}`

    Apaga o feedback com o `id` informado no parâmetro de path.

    #### Códigos de Resposta

    |código|descrição|
    |------|---------|
    |201| Feedback apagado com sucesso
    |401| Não autorizado. Realize a autenticação em /login
    <br/>

- Apagar empresa

    `DELETE` /companies/`{id}`

    Apaga a empresa com o `id` informado no parâmetro de path.

    #### Códigos de Resposta

    |código|descrição|
    |------|---------|
    |201| Feedback apagado com sucesso
    |401| Não autorizado. Realize a autenticação em /login
    <br/>



### Método Detalhar

- Detalhar usuários

    `GET` /users/`{id}`

    Retorna os dados do usuário com o `id` informado no parâmetro de path.

    #### Exemplo da Resposta

    ```js
    // requisição /user/1
    {
        "id": "1",
        "name": "Pedro",
        "registrationDate": "2023-04-01",
        "gender": "Masculine",
        "aged": "false",
        "timeOfService": "18",
        "exitForecast": "2025-06-13"
    }
    ```

    #### Código de Resposta

    |código|descrição|
    |------|---------|
    |204| Usuário retornado com sucesso
    |401| Não autorizado. Realize a autenticação em /login
    |404| Não existe usuário com o `id` informado

- Detalhar feedbacks

    `GET` /feedbacks/`{id}`

    Retorna os dados do feedback com o `id` informado no parâmetro de path.

    #### Exemplo da Resposta

    ```js
    // requisição /feedbacks/1
    {
        "id": 1,
        "user": "Pedro",
        "feeling": "Regular",
        "date": "2023-07-25",
        "company": "Microsoft"
    }
    ```

    #### Código de Resposta

    |código|descrição|
    |------|---------|
    |204| Feedback retornado com sucesso
    |401| Não autorizado. Realize a autenticação em /login
    |404| Não existe feedback com o `id` informado

- Detalhar empresas

    `GET` /companies/`{id}`

    Retorna os dados da empresa com o `id` informado no parâmetro de path.

    #### Exemplo da Resposta

    ```js
    // requisição /companies/1
    {
        "id": "1",
        "name": "Microsoft",
        "registrationDate": "2023-10-02",
        "numberOfFeedbacks": "1",
        "branch": "Omni CRM"
    }
    ```

    #### Código de Resposta

    |código|descrição|
    |------|---------|
    |204| Empresa retornada com sucesso
    |401| Não autorizado. Realize a autenticação em /login
    |404| Não existe empresa com o `id` informado

### Método Atualizar

- Atualizar Usuário


    `PUT` /users/`{id}`

    Atualiza os dados do usuário com o `id` informado na path.

    #### Corpo da Requisição

    |campo|tipo|obrigatório|descrição|
    |-----|----|:-----------:|---------|
    |name|string|✅|Nome do usuário matriculado
    |registrationDate|localdate|✅|Data de cadastro do usuário
    |isSatisfied|boolean|✅|Satisfação do usuário
    |gender|string|✅|Gênero do usuário
    |aged|boolean|✅|Verificar se o usuário é idoso
    |timeOfService|bigdecimal|✅|Tempo de serviço em meses
    |exitForecast|localdate|✅|Previsão de saída

    ```js
    {
        "name": "Pedro",
        "registrationDate": "2023-04-01",
        "gender": "Masculine",
        "aged": "false",
        "timeOfService": "18",
        "exitForecast": "2025-06-13"
    }
    ```

    #### Exemplo da resposta

    ```js
    {
        "id": "1",
        "name": "Pedro",
        "registrationDate": "2023-01-04",
        "gender": "Masculine",
        "aged": "false",
        "timeOfService": "18",
        "exitForecast": "2025-06-13"
    }
    ```

    #### Códigos de Resposta

    |código|descrição|
    |------|---------|
    |204| Usuário retornado com sucesso
    |400| Validação falhou. Verifique os dados enviados no corpo da requisição
    |401| Não autorizado. Realize a autenticação em /login
    |404| Não existe usuário com o `id` informado

    ---
    <br/>

- Atualizar Feedback

    `PUT` /feedbacks/`{id}`

    Atualiza os dados do feedback com o `id` informado na path.

    #### Corpo da requisição

    |campo|tipo|obrigatório|descrição|
    |-----|----|:-----------:|---------|
    |user|string|✅|Nome do usuário que fez o feedback
    |feeling|enum|✅|Sentimento do dono do feedback
    |date|localdate|✅|Data de criação do feedback
    |company|string|✅|Empresa-alvo do feedback

    ```js
    {
        "user": "Pedro",
        "feeling": "Regular",
        "date": "2023-07-25",
        "company": "Microsoft"
    }
    ```

    #### Exemplo da resposta

    ```js
    {
        "id": 1,
        "user": "Pedro",
        "feeling": "Regular",
        "date": "2023-07-25",
        "company": "Microsoft"
    }
    ```

    #### Códigos de Resposta

    |código|descrição|
    |------|---------|
    |204| Feedback retornado com sucesso
    |400| Validação falhou. Verifique os dados enviados no corpo da requisição
    |401| Não autorizado. Realize a autenticação em /login
    |404| Não existe feedback com o `id` informado

    ---
    <br/>

- Atualizar Empresa

    `PUT` /companies/`{id}`

    Atualiza os dados da empresa com o `id` informado na path.

    #### Corpo da requisição

    |campo|tipo|obrigatório|descrição|
    |-----|----|:-----------:|---------|
    |name|string|✅|Nome da empresa em cadastro
    |registrationDate|localdate|✅|Data de cadastro da empresa
    |numberOfFeedbacks|integer|✅|Número de feedbacks que a empresa contém
    |branch|string|✅|Ramo da Plusoft que a empresa está

    ```js
        {
            "name": "Microsoft",
            "registrationDate": "2023-10-02",
            "numberOfFeedbacks": "1",
            "branch": "Omni CRM"
        }
    ```

    #### Exemplo da resposta

    ```js
        {
            "id": "1",
            "name": "Microsoft",
            "registrationDate": "2023-10-02",
            "numberOfFeedbacks": "1",
            "branch": "Omni CRM"
        }
    ```

    #### Códigos de Resposta

    |código|descrição|
    |------|---------|
    |204| Empresa retornada com sucesso
    |400| Validação falhou. Verifique os dados enviados no corpo da requisição
    |401| Não autorizado. Realize a autenticação em /login
    |404| Não existe empresa com o `id` informado

    ---