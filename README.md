# poc-envioemail

Api de Envio de Email para sistema de vendas de produtos.

Tecnologias utilizadas:

* Java
* Redis
* Docker

Padões de projetos utilizados:

* Template Method

## Instruções ##

build do projeto: mvn clean install

subir o docker compose

docker-compose build --no-cache ( Construir/ buidar imagens )
docker-compose up --force-recreate -d (Subir o docker sem prender o terminal)

### Validações ###

* NomeCliente, order, email, motivo: Obrigatório
* Produtos: Obrigatório

### Exemplos Entradas ###

http://localhost:8081/ordersemails/pedidorecusado

{
    "nomeCliente": "Carlos",
    "orderNumber": 123123,
    "emailCliente": "carlosslopes1985@hotmail.com",
    "motivo": "Pagamento Não Autorizado pela instituição financeira!"
}

http://localhost:8081/ordersemails/pedidoconfirmado

{
    "nomeCliente": "Carlos",
    "orderNumber": 122321,
    "emailCliente": "carlosslopes1985@hotmail.com",
    "totalOrder": 1260.,
    "prods": [
        {
            "name": "Ração",
            "quantity": 2,
            "unitPrice": 1000.0,
            "subTotal": 200.0
        },
        {
            "name": "Pé de pato",
            "quantity": 10,
            "unitPrice": 150.0,
            "subTotal": 1500.0
        },
        {
            "name": "Televisão",
            "quantity": 9,
            "unitPrice": 100002.0,
            "subTotal": 30006.0
        }
    ]
}

