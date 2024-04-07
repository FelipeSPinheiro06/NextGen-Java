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
#### Para ver melhor o diagrama, acesse [aqui](#https://lucid.app/lucidchart/a0fc1580-7050-44fe-aded-730dcba88d91/edit?viewport_loc=526%2C467%2C4267%2C1982%2CHWEp-vi-RSFO&invitationId=inv_3ceb64c0-1371-4540-99c9-09216c3434c0)

<img src="src/images/NextGen Project.png">

### Diagrama Entidade-Relacionamento
#### {A fazer}


## Proposta para a Plusoft

#### Clique [aqui](#https://youtu.be/wQaMeada2r0) para acessar o vídeo da nossa proposta para a Plusoft

## Recursos

- [ ] CRUD de Usuários
- [ ] CRUD de Feedbacks
- [ ] CRUD de Empresas

## Documentação

### Endpoints

- [Método Listar]()
- [Método Cadastrar]()
- [Método Detalhar]()
- [Método Apagar]()
- [Método Atualizar]()

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
            "registrationDate": "04-01-2024",
            "gender": "Masculine",
            "aged": "false",
            "timeOfService": "18",
            "exitForecast": "06-13-2025"
        }
    ]
    ```

    Obs: O atributo "timeOfService" é medido em meses


    #### Códigos de resposta

    |código| descrição|
    |------|----------|
    |200| Aluno retornado com sucesso
    |401| Autorizado não autorizado. Realize a autenticação em /login 
    <br/>


-  Listar Feedback



### Cadastrar Alunos

`POST` /alunos

Cadastro um aluno com o corpo de uma requisição

#### Corpo da requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Nome do aluno matriculado
|turma|string|✅|Turma do aluno respectivo

```js
{
    "nome": "Pedro",
    "turma": "A"
}
```

#### Exemplo da resposta

```js
{
    "RM": 1,
    "nome": "Pedro",
    "turma": "A"
}
```

#### Códigos de Resposta

|código|descrição|
|------|---------|
|200| Aluno cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| não Autorizado. Realize a autenticação em /login


### Apagar Alunos

`DELETE` /categoria/`{id}`

Apaga a categoria com o `id` informado no parâmetro de path.


#### Códigos de Resposta

|código|descrição|
|------|---------|
|201| Aluno apagado com sucesso
|401| Não autorizado. Realize a autenticação em /login



### Detalhar Alunos

`GET` /alunos/`{id}`

Retorna os dados do aluno com o `id` informado no parâmetro de path.

#### Exemplo da Resposta

```js
// requisição /aluno/1
{
    "RM": 1,
    "Nome": "Pedro",
    "Turma": "A"
}
```

#### Código de Resposta

|código|descrição|
|------|---------|
|204| Aluno retornado com sucesso
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe categoria com o `id` informado


### Atualizar Alunos

`PUT` /aluno/`{id}`

Atualiza os dados da categoria com o `id` informado na path.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|nome do aluno matriculado
|turma|string|✅|turma do aluno respectivo

```js
{
    "nome": "Pedro",
    "turma": "A"
}
```

#### Exemplo da resposta

```js
{
    "RM": 1,
    "nome": "Pedro",
    "turma": "A"
}
```

#### Códigos de Resposta

|código|descrição|
|------|---------|
|204| Aluno retornado com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe categoria com o `id` informado

---
