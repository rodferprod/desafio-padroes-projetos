# Desafio Padrões de Projetos com Spring

## Construindo uma RestAPI para registro de clientes com endereço completo

### Padrões aplicados:
- Singleton:  Injeção de componentes com @Autowired
- Strategy:   Implementa métodos definidos em interfaces
- Facade:     Promove uma interface simples integrando subsistemas

#### Requisitos mínimos para registro de um cliente:
- Nome e CEP

##### Modelo do Registro
```
{
  "id": "Long",
  "name": "string",
  "address": {
    "cep": "string",
    "logradouro": "string",
    "complemento": "string",
    "bairro": "string",
    "localidade": "string",
    "uf": "string",
    "ibge": "string",
    "gia": "string",
    "ddd": "string",
    "siafi": "string"
  }
}
```
