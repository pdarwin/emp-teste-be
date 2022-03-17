# Projeto Livraria Requalificar
Projeto do curso Requalificar - Grupo 8

## Requisitos
- O sistema deve suportar dois tipos de utilizador, osclientese os funcionários da livraria.
- Os clientes são caracterizados por um nome, um email, uma morada e uma data de nascimento.
- Os clientes devem ser capazes de se registar na aplicação, e consequentemente de fazer a sua autenticação através do uso de uma palavra-passe.
- Após a autenticação, o cliente deve ter acesso à loja e consequentemente deve conseguir ver todos os livros
disponíveis na livraria Requalificar.
- Um livro é caracterizado por um autor, um título, um ISBN, um preço, uma quantidade em stock, uma editora, uma data de lançamento, um número de páginas, uma sinopse, uma edição e uma imagem de capa. 
- Um livro pode ser escrito por vários autores que são respetivamente caracterizados por um nome, uma data de nascimento e um email.
- Uma editora é caracterizada por um nome e uma morada. Um autor pode apenas pertencer a uma editora.
- A página inicial do sistema deve apresentar ao cliente uma navbar (com o seu carrinho de compras e o seu perfil) e todos os livros da livraria numa vista reduzida, onde só é apresentado a imagem, o título e o preço do livro.
- Deve ser dado a opção ao cliente de organizar os livros por preço crescente e preço decrescente.
- Deve ser também dado a possibilidade de filtrar os livros por editora, por autor e por data de lançamento.
- Ao clicar no livro, uma nova página deverá ser apresentada onde o cliente poderá ver todos os aspetos do livro, incluído adicioná-lo ao seu carrinho de compras, caso o livro esteja disponível em stock.
- Ao clicar no carrinho de compras, o cliente poderá fazer uma pré-visualização do total do carrinho, podendo aumentar ou diminuir a quantidade de livros já existentes e podendo também prosseguir para o pagamento. Ao efetuar o pagamento, poderá opcionalmente adicionar no máximo um cupão de desconto que possa ter. Após o pagamento ser efetuado, deverá ser apresentada uma mensagem de compra efetuada com sucesso. 
- Caso a compra efetuada pelo cliente seja superior a 50 euros, deverá receber um cupão de 5% de desconto, caso seja superior a 100 euros deverá receber um cupão de 15% de desconto.
- Ao clicar no seu perfil, o cliente poderá ver todas as suas compras efetuadas. Deverá também ser capaz de ver todos os cupões que possuí (incluído os que já foram usados). No perfil deve ser também dado a opção de alterar a palavra-passe, a morada e o email.
- Os funcionários da livraria devem também fazer o seu registo. Um funcionário é caracterizado por um nome, uma data de nascimento e um nickname gerado
automaticamente a partir do nome.
- Igualmente ao cliente, após a autenticação do funcionário, este irá encontrar a página inicial com todos os livros da livraria e uma navbar onde será permitido adicionar uma editora, um autor e um livro. Irá conseguir aplicar as mesmas técnicas de filtragem e organização. 
- Ao selecionar um livro, irá ser aberto uma nova página onde o utilizador irá conseguir alterar todas as características do livro.
- Adicionalmente, os funcionários também conseguem obter estatísticas sobre as vendas, nomeadamente sobre os gastos dos utilizadores (ordenar por
ordem crescente e decrescente), que livros venderam mais e/ou copias e que livros foram os mais/menos rentáveis.
- Ambos os utilizadores devem também ter a possibilidade de efetuar o logout.

## Diagrama *use case* 
![Livraria Requalificar (Passo 1)](https://user-images.githubusercontent.com/97111949/158906302-c1afd7ca-67f8-4356-83f5-6ef992690fc3.png)

![Livraria Requalificar](https://user-images.githubusercontent.com/97111949/158906706-85759758-a3c7-4b48-863d-cedf00ec0939.png)
