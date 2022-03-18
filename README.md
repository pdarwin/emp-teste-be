# Projeto Livraria Requalificar
Projeto do laboratório de programação, curso Requalificar - Grupo 8

## Requisitos
1 - O sistema deve suportar dois tipos de utilizador: Clientes e os Funcionários da livraria.
2 - Os clientes devem ser caracterizados por um nome, um email, uma morada e uma data de nascimento.
3 - Os clientes devem ser capazes fazer o registo pela aplicação, e consequentemente de fazer a sua autenticação através do uso de uma palavra-passe.
4 - Após a autenticação, o cliente deve ter acesso à loja e consequentemente conseguir ver todos os livros
disponíveis na Livraria Requalificar.
5 - Um livro deve ser caracterizado por um autor, um título, um ISBN, um preço, uma quantidade em stock, uma editora, uma data de lançamento, um número de páginas, uma sinopse, uma edição e uma imagem de capa. 
6 - Um livro pode ser escrito por vários autores que são respetivamente caracterizados por um nome, uma data de nascimento e um email.
7 - Uma editora é caracterizada por um nome e uma morada. Um autor pode apenas pertencer a uma editora.
8 - A página inicial do sistema deve apresentar ao cliente uma navbar (com o seu carrinho de compras e o seu perfil) e todos os livros da livraria numa vista reduzida, onde só é apresentada a imagem, o título e o preço do livro.
9 - Deve ser dado a opção ao cliente de organizar os livros por preço crescente e preço decrescente.
10 - Deve ser também dado a possibilidade de filtrar os livros por editora, por autor e por data de lançamento.
11 - Ao clicar no livro, uma nova página deverá ser apresentada onde o cliente poderá ver todos os aspetos do livro, incluído a opção de adicioná-lo ao carrinho de compras, caso o livro esteja disponível em stock.
12 - Ao clicar no carrinho de compras, o cliente poderá fazer uma pré-visualização do total do carrinho, podendo aumentar ou diminuir a quantidade de livros já existentes e podendo também prosseguir para o pagamento. 
13 - Ao efetuar o pagamento, deverá ser opcionalmente possível adicionar no máximo um cupão de desconto. 
14 - Após efetuado o pagamento, deverá ser apresentada uma mensagem: Compra efetuada com sucesso! 
15 - Caso a compra efetuada pelo cliente seja superior a 50 euros, o mesmo deverá receber um cupão de 5% de desconto. 
Caso seja superior a 100 euros, deverá receber um cupão de 15% de desconto.
16 - Ao clicar no perfil (navbar), o cliente poderá ver todas as compras efetuadas. 
Deverá também ser capaz de ver todos os cupões que possuí no momento, incluído os que já foram usados. 
17 - No perfil, deverá ser também dado a opção de alterar a palavra-passe, a morada e o email (dados do cliente).
18 - Os funcionários da livraria devem também fazer o seu registo. 
19 - Um funcionário é caracterizado por um nome, uma data de nascimento e um nickname gerado automaticamente a partir do nome.
20 - Após a autenticação do funcionário, o mesmo deverá encontrar a página inicial com todos os livros da livraria e uma navbar onde será permitido adicionar uma editora, um autor e um livro. 
Sendo possível aplicar as mesmas técnicas de filtragem e organização que o cliente. 
21 - Ao selecionar um livro, deverá ser aberta uma nova página onde o funcionário pode alterar todas as características da obra.
22 - Adicionalmente, os funcionários também conseguem obter estatísticas sobre as vendas, nomeadamente sobre os gastos dos utilizadores.
23 - Deverá ser possível ordenar as vendas por ordem crescente e decrescente, os livros que venderam mais e/ou as cópias (livros) que foram mais e menos rentáveis.
24 - Ambos os utilizadores devem ter a possibilidade de efetuar logout ao sistema.


## Diagrama *use case* 
![Livraria Requalificar (Passo 1)](https://user-images.githubusercontent.com/97111949/158906302-c1afd7ca-67f8-4356-83f5-6ef992690fc3.png)

![Livraria Requalificar](https://user-images.githubusercontent.com/97111949/158906706-85759758-a3c7-4b48-863d-cedf00ec0939.png)
