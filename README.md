
# AirCheck

Este é um aplicativo para Android criado com Kotlin. O aplicativo mostra a qualidade do ar da cidade inserida pelo usuário. Também mostra mais informações sobre a escala IQA (Índice de Qualidade do Ar). O app consome uma api que fornece os dados para serem exibidos em tela.




## Documentação da API

#### Retorna o IQA (Índice de Qualidade do Ar)

```http
  GET /feed/:city/?token=:token
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `city` | `string` | **Obrigatório**. Nome da cidade |
| `token` | `string` | **Obrigatório**. A sua chave da API |

Para mais informações da api consumida:

[Documentação Api](https://aqicn.org/json-api/doc/#api-_)

[Overview Api](https://aqicn.org/api/)


