
# Batalha Naval - Projeto de Programação Orientada a Objetos (POO)

Este é um projeto desenvolvido em Java que simula o clássico jogo **Batalha Naval**, aplicando os princípios de **Programação Orientada a Objetos (POO)**. O jogo permite que dois jogadores disputem entre si posicionando seus navios e tentando acertar os navios do oponente.

## Estrutura do Projeto

```
src/
├── Main.java                 # Classe principal que executa o jogo
├── Player.java               # Classe que representa os jogadores
├── Embarcacoes.java          # Enum com os tipos de embarcações disponíveis
│
├── fleet/                    # Pacote com as classes dos navios
│   ├── Navio.java
│   ├── PortaAvioes.java
│   ├── ContraTorpedeiro.java
│   ├── Patrulheiro.java
│   ├── Submarino.java
│   └── Posicao.java          # Classe para representar posições no tabuleiro
│
├── maps/                     # Pacote responsável pelos tabuleiros
│   ├── Board.java
│   ├── HiddenBoard.java      # Tabuleiro oculto (não mostra navios inimigos)
│   └── PlayerBoard.java      # Tabuleiro visível do jogador
│
└── playerQueues/             # Pacote que gerencia as filas de navios
    ├── PlayersVesselQueue.java
    └── VesselQueue.java
```

## Funcionalidades

- Dois jogadores humanos se enfrentam em rodadas alternadas.
- Cada jogador possui um tabuleiro próprio e um tabuleiro oculto para visualizar os disparos no adversário.
- As embarcações disponíveis são:
  - Porta-Aviões (5 espaços)
  - Contra-Torpedeiro (4 espaços)
  - Submarino (3 espaços) — 2 unidades
  - Patrulheiro (2 espaços) — 2 unidades
- Validação de posições para garantir que navios não sejam sobrepostos ou posicionados fora do tabuleiro.
- Feedback visual do estado do tabuleiro:
  - `~` para água
  - Letra correspondente ao navio (`P` para Porta-Aviões, `C` para Contra-Torpedeiro, etc.).
  - `X` para acerto
  - `O` para erro (tiro na água)
- Impressão dos tabuleiros após cada jogada.

## Tecnologias Utilizadas

- **Java 17** (ou superior recomendado)
- Paradigma de **Programação Orientada a Objetos (POO)**

## Como Executar

1. Clone ou baixe este repositório.

2. Compile os arquivos Java:

```bash
javac src/**/*.java
```

3. Execute o jogo:

```bash
java -cp src Main
```

## Melhorias Futuras

- Implementar uma interface gráfica (GUI) usando JavaFX ou Swing.
- Criar um modo de jogo contra IA.
- Adicionar sons e animações.
- Implementar sistema de pontuação e histórico de partidas.

## Autores
- Patrick Correa
- Pedro Castello
- Ruan Martins

---

- Projeto desenvolvido como parte da disciplina de **Programação Orientada a Objetos 1 (POO1)**.
