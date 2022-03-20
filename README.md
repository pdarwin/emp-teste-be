# Projeto Livraria Requalificar

__Requalificar +DIGITAL Java__

__Laboratório de Programação__

__Grupo 8__

- João Rocha

- Paulo Santos Perneta


## Requisitos

__1.1.__	O sistema deve permitir o registo pela aplicação de dois utilizadores: Cliente e Funcionário;

__1.2.__	Após o registo, ambos os utilizadores deveram receber uma validação por email;

__1.3.__	O sistema deve permitir ao cliente fazer login através do endereço eletrónico (email), juntamente com a password;

__1.4.__	O sistema deve permitir ao funcionário fazer login através do endereço eletrónico (email), ou username (nome de utilizador), juntamente com a password;

__1.5.__	O username do funcionário, deverá ser calculado a partir da primeira letra do nome, mais sobrenome em conjunção com a adição do número inteiro consecutivo ao último usado, caso exista;

__1.6.__	A password, em ambos os casos de utilização, deverá ter um número mínimo de 8 caracteres;

__1.7.__	A password deverá possuir pelo menos uma letra maiúscula, uma letra minúscula e um número;

__1.8.__	Após a autenticação (login), ambos os utilizadores devem ter acesso à Loja (página inicial do sistema) e todos os seus livros disponíveis;

__1.9.__	Os livros da página inicial deverão estar expostos numa vista reduzida;

__1.10.__	Todos os livros expostos na página inicial do sistema, deveram ser apresentados apenas pela imagem, título e preço;

__1.11.__	Os utilizadores devem poder organizar os livros por preço crescente;

__1.12.__	E, adicionalmente, por ordem também decrescente;

1.13.	Para além disso, ambos os utilizadores poderão filtrar os livros (em vista reduzida), por editora;

1.14.	A filtragem / ordenação por autor também é uma opção;

1.15.	E por fim, a opção de filtrar por data de lançamento também é uma possibilidade;

1.16.	Ao clicar sobre um livro selecionado, uma nova página deverá ser apresentada perante o cliente, onde constará todos os detalhes da obra;

1.17.	Um livro deverá ser caracterizado por um autor, um título, um ISBN, um preço, uma quantidade em stock, uma editora, uma data de lançamento, um número de páginas, uma sinopse, uma edição e uma imagem de capa;

1.18.	Se um funcionário clicar sobre o livro selecionado, a nova página aberta (gerada) deve dar a possibilidade de alterar todas as características da obra escolhida;

1.19.	Os funcionários também podem, na mesma página, obter estatísticas sobre as vendas do livro;

1.20.	Nomeadamente sobre os gastos de utilizadores;

1.21.	Com possibilidade de filtrar / ordenar por ordem crescente;

1.22.	E inclusive, por ordem também decrescente;

1.23.	Quais as cópias / edições do livro que venderam mais;

1.24.	Quais foram os livros mais rentáveis;

NOUTRA PÁGINA?

1.25.	Quais foram os livros menos rentáveis;

1.26.	No caso do cliente, a possibilidade de adicionar o livro ao seu carrinho de compras, através da mesma página de detalhes, deve ser uma opção;

1.27.	Caso a obra se encontra disponível em stock;

1.28.	Se não for esse o caso, deverá constar nos detalhes literários a seguinte mensagem: Sem stock de momento!

1.29.	Caso o stock do livro indicado esteja para breve, a seguinte mensagem deve constar nos detalhes (características) do livro: Stock para breve!

1.30.	Na página inicial do sistema, o sistema deve apresentar ao cliente e funcionário uma navbar (barra de navegação);

1.31.	Ambos os utilizadores poderão aceder aos dados de perfil de forma a alterá-los, pela navbar (barra de navegação);

1.32.	O cliente pode alterar no perfil a palavra-passe, a morada e o seu email;

1.33.	Por sua vez o funcionário, pode aceder aos seus dados de perfil: nome, data de nascimento e nickname (username) gerado automaticamente;

POSSIBILIDADE DE ALTERAÇÃO?

1.34.	No caso do cliente, ao clicar no perfil deve ser possível visualizar todas as compras efetuadas;

1.35.	Inclusive, deverá também ser apresentada a informação dos cupões disponíveis no momento;

1.36.	E, adicionalmente, a informação dos cupões que já foram usados;

1.37.	Através da navbar, somente o cliente tem a opção adicional de visualizar o carrinho de compras;

1.38.	Ao clicar no carrinho, o cliente poderá fazer uma pré-visualização do total do carrinho a pagar;

1.39.	Podendo aumentar ou diminuir a quantidade de livros, já existentes no carrinho;

1.40.	Também é possível proceder diretamente para o pagamento;

1.41.	Na secção (página) de efetuar o pagamento, o cliente pode adicionar num campo, opcionalmente, um cupão de desconto que possa ter;

1.42.	Só é possível adicionar no máximo um cupão de desconto;

1.43.	Após o pagamento ser efetuado, deverá ser apresentada a seguinte mensagem: Compra efetuada com sucesso!

1.44.	Caso a compra em questão seja superior a 50 euros, o cliente deverá receber um cupão de 5% de desconto;

1.45.	Caso seja superior a 100 euros, o cupão de oferta passa a ser de 15% de desconto;

1.46.	No caso do funcionário, a navbar tem a possibilidade extra de adicionar uma editora, um autor e um livro;

1.47.	Uma editora é caracterizada por um nome e uma morada;

1.48.	Um autor é caracterizado por um nome, uma data de nascimento e um email;

1.49.	Um autor pode pertencer apenas a uma editora;

1.50.	E um livro, por sua vez, pode ter sido escrito por vários autores;

1.51.	Ambos os utilizadores devem ter a possibilidade de terminar sessão (logout).


## Diagrama *Use Case*

__Primeira Idealização__

![Livraria Requalificar (Passo 1)](https://user-images.githubusercontent.com/97111949/159070763-908da997-fc3b-4c92-acae-32a8bbbd1f87.png)


__Proposta Final de Use Case Model__

![Diagrama Use Case - Livraria Requalificar](https://user-images.githubusercontent.com/97111949/159070863-3d46bc65-0bea-4f45-b30b-3247f2cd9db0.png)

__Proposta Final de Use Case Model (Generalização entre os Atores)__

![Diagrama Use Case - Livraria Requalificar 'Final'](https://user-images.githubusercontent.com/97111949/159177808-f80d9981-eac1-4de2-9444-7057d6287141.png)
