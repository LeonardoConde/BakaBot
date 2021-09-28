

<Center><h1>Music Bot Quiz on Discord</h1><br><br><br><b>Instituição:</b><br><br>Pontifícia Universidade Católica de São Paulo<br><br><br><br><br><b>Matéria:</b><br><br>Laboratório de Projetos de Software /LPS-2021<br><br><br><br><br><br><b>Professor responsável:</b><br><br>Italo Santiago Vega<br><br><br><br><br><br><b>Equipe:</b><br><br>  Kahao Yu,<br> Leonardo de Jesus Diz Conde,<br> Marcelo Maués Botelhos,<br> Victor Yuji Saito.<br><br><br> <br><br><br><br><br>Data:</b><br>22/09/2021<br><br>V.2.1 </Center>



------

<div style="page-break-after: always"></div><Center><h2>Sumário:</h2></Center>

- [1. Objetivo (Definição do projeto)](#1. Objetivo (Definição do projeto))
  - 1.1. Contexto do Problema
  - 1.2. Introdução
  - 1.3. Complicações

- [2. Análise do problema](#2. Análise do problema: )
  - 2.1. Considerações prévias do grupo
  - 2.2. Análise Prévia do Objetivo
  - 2.3. Análise do Domínio
    - 2.3.1. Conceito
    - 2.3.2. Objetos
  - 2.4. Mapeamento conceitual
    - 2.4.1. Regras de Negócio
    - 2.4.2. Casos de usos
  - 2.5. Modelo de Domínio
  - 2.6. Modelo de Desenho
  - 2.7. Requisitos
- [3. Desenho](#3. Desenho: )
- [4.Implementação](#4.Implementação: )
- [5. Conclusões](5. Conclusões: )



<div style="page-break-after: always"></div>

## 1. Objetivo (Definição do projeto): 

### 1.1. Contexto do Problema: 

​	O nosso objetivo é criar um *bot* destinado a rede social chamada *Discord* que terá as seguintes funcionalidades: <b>tocar</b> músicas, ter um **quiz** de músicas temáticas e comando para auxiliar no uso dos comandos disponíveis dele. 

​	A funcionalidade de **tocar** música deverá permitir tocar músicas requisitadas pelo usuário, além de apresentar alguns comandos para o melhor controle das músicas. 

​	O participante do **quiz** de músicas temáticas tem como objetivo acertar o maior número de “origens” da música (exemplo: se o tema é *anime*, o usuário deverá acertar o *anime* em que a música aparece). Contudo, para dar chance a todos os jogadores, o *bot* deve aumentar a chance de uma música conhecida aparecer, mas não ao ponto de todas serem conhecidas, para que também possa despertar a curiosidade de alguns usuários em buscar novas experiências. 

​	Já o comando de **auxilio**, poderá ser feito de 2 maneiras: a menção ao *bot* no *chat* de texto (exemplo de mensagem: "@< Nome do bot >") ou pelo prefixo do *bot* junto da palavra “help”. 

 

### 1.2. Introdução: 

​	Nossas inspirações vem principalmente de 2 lugares: [Anime Music List (AMQ)](https://animemusicquiz.com/) e dos *bots* que a rede social [Discord](https://discord.com/), sendo a [Loritta](https://loritta.website/br/) um exemplo que o grupo considera como um projeto de sucesso e inspiração. Fora isso, os integrantes do grupo, em um geral, estava interessado em criar uma aplicação real-time e que pudéssemos aplicar conceitos de outras matérias que estamos vendo nesse semestre. 

 

### 1.3. Complicações: 

​	**RNF1**: O projeto envolve o uso de interface que não é gerenciada pelos membros do projeto, portanto a primeira complicação é que o projeto deve seguir as regulamentações desse serviço (Discord) que está disponível no [site de politicas aos desenvolvedores](https://discord.com/developers/docs/policy). Um problema que os membros irão se deparar é com uma questão que surgiu após a idealização desse projeto é que o *bot* de música mais usado pela comunidade do Discord (o [Groovy](https://groovy.bot/)), onde ele foi forçado a ser imobilizado por questões de integrações com algumas API's de músicas com o Youtube, mais informações disponíveis na [matéria feita pelo portal Tecmundo](https://www.tecmundo.com.br/internet/223918-youtube-ordena-encerramento-bot-groovy-discord.htm) e o [pronunciamento do criador do Groovy](https://cdn.discordapp.com/attachments/699298963521667244/880154702623436810/unknown.png). (última visualização dos links: 06/08/2021)

​	**RNF2:** Tendo um mês se passado da polemica do Groovy, mais dois *bots* acabaram tendo suas ações paralizadas pelas mesmas questões, um deles foi o [Rythm](https://rythm.fm/) e o outro foi o [Hydra](https://hydra.bot/).  (última visualização dos links: 21/09/2021)

------

<div style="page-break-after: always"></div>

## 2. Análise do problema: 

### 2.1. Decisões prévias:

#### 2.1.1. Funcionáis:

​	Para facilitar na produção da aplicação, o grupo definiu que o jogo irá se basear inicialmente em 10 músicas por jogo, se possível tentaremos tornar esse aspecto modular.

#### 2.1.2. Cosméticas:

​	Para o icone do *bot* difinimos que será a imagem a baixo:

<img src="C:\Users\leoca\Desktop\DiscordBotDocumentacao\MQB_Icon.jpg" alt="MQB_Icon" style="zoom:10%;" />

​	Ela foi produzida com base em uma foto de um integrante do grupo, passamos por um filtro do Snapchat, usamos a imagem em um aplicativo chamado [Remini](https://remini.ai/) e ao final fizemos uma edição de imagem com o Gimp para recortar a cabeça e colocar no fundo de [espaço](https://cutewallpaper.org/download.php?file=/21/space-1920x1080-wallpaper/Background-Images-1920x1080-Ultra-Hd-Space-Triangles-.jpg). Quanto ao nome, defimos que seria “Baka!” por conta de piadas internas do grupo.

### 2.2. Análise Prévia do Objetivo: 

- Quiz de músicas (analogia): 
  Normalmente nos jogos desse gênero, uma música é apresentada por um periodo curto e os usuários devem acertar o nome, gênero, época, ou banda/grupo/artista (depende do jogo para definir o objetivo) e ao final da partida é mostrada a resposta. 
  
- Áudio Player (componente conceitual): 

  Os *bots* que envolvem áudio, quase que por sua totalidade, implementam a funcionalidade de áudio *player*, ou seja, ele irá reproduzir uma música em um canal de voz no momento que um usuário pede, além desse ter a possibilidade de pausar/tocar a música, adicionar mais músicas, pular e parar a reprodução. 

 

### 2.3. Análise do Domínio: 

#### 2.3.1. Conceito:

<img src="C:\Users\leoca\Desktop\DiscordBotDocumentacao\BotDiscord-Modulo4-Análise de dominio.Conceito.png" alt="BotDiscord-Modulo4-Análise de dominio.Conceito" style="zoom:150%;" />

#### 2.3.2. Objetos:

![BotDiscord-Modulo4-Análise de dominio.Objetos](C:\Users\leoca\Desktop\DiscordBotDocumentacao\BotDiscord-Modulo4-Análise de dominio.Objetos.png)

- Ouvinte 
- Jogador
- Áudio
- Álbum
- Reprodutor de áudio 
- Quiz

### 2.4. Mapeamento conceitual:

#### 2.4.1. Regras de Negócio:

<img src="C:\Users\leoca\Desktop\DiscordBotDocumentacao\regrasDeNegócio.png" alt="regrasDeNegócio" style="zoom:175%;" />

​	As regras de negócio que a aplicação deve seguir são:

- Gerais:

  ​	Um *bot*, assim como um usuário, só pode estar conectado a um canal de voz por servidor, por isso ele deverá ter o controle das ações que estão acontecendo para não deixar que as suas funcionalidades não entrem em conflito. Já com relação as mensagens de texto, as únicas limitações existentes são aquelas que infrigem as políticas do Discord (comentada no tópico *1.3. Complicações*). 

- Reprodutor de áudio:

  Disponibilidade d= estar dentro do acervo de áudios disponibilizados pelo bot;

- Quiz:

  ​	A pontuação de cada jogador ( $$P_{m}$$) é dada pela quantidade de músicas de músicas acertadas, representada pela fórmula abaixo:
  $$
  P_{m}=\sum_{n = 1}^{10} (t_{n}=g_{n})?1:0
  $$
  ​	Considerando $$t_{n}$$ como a última tentativa do jogador $$P_{m}$$  para cada música e $$g_{n}$$ a resposta de cada música.

  ​	Já o ganhador do jogo, dada pela regra r, é obtida com base no jogador que concluir com maior pontuação, ou seja, o maior $$P_{m}$$ .
  
  ​	O jogo terá seu fim quando todas as músicas terminarem de tocar. Com isso

#### 2.4.2. Casos de usos:

![Análise de dominio.drawio](C:\Users\leoca\Desktop\DiscordBotDocumentacao\Análise de dominio.drawio.png)



### 2.5. Modelo de Domínio: 

![BotDiscord-Modelo de dominio.drawio (1)](C:\Users\leoca\Desktop\DiscordBotDocumentacao\BotDiscord-Modelo de dominio.drawio (1).png)

### 2.6. Modelo de Desenho: 

![BotDiscord-Modelo de desenho.drawio](C:\Users\leoca\Desktop\DiscordBotDocumentacao\BotDiscord-Modelo de desenho.drawio.png)

### 2.7. Requisitos:

1. O bot deve apresentar a possibilidade de aumentar a chance de uma música conhecida aparecer no quiz;  

2. Quando uma música está sendo tocada (no modo do reprodutor de áudio), o usuário poderá usar comandos para pausar/despausar a música;  

3. Ao final de cada jogo, o bot deverá apresentar o placar da pontuação obtida pelos jogadores;

4. O bot deverá ter a capacidade de criar um canal para suas funcionalidades de quiz e de reprodutor de áudios;
5. O bot deve apresentar um comando de “ajuda”;

------

<div style="page-break-after: always"></div>

## 3. Desenho: 

### 3.1. Arquitetura: 

//TODO 

### 3.2. Implementação: 

//TODO 

------

<div style="page-break-after: always"></div>

## 4.Implementação: 

### 4.1. Objetos de Implementação: 

//TODO 

### 4.2. Testes: 

//TODO 

------

<div style="page-break-after: always"></div>

## 5. Conclusões: 

//TODO 
