# 🚢 Jogo de Batalha Naval em Java

Projeto desenvolvido como trabalho final da disciplina de **Programação Orientada a Objetos I (POOI)**. Este projeto consiste em uma implementação do clássico jogo de **Batalha Naval**, onde dois jogadores (humano vs humano) competem posicionando e atacando embarcações em um tabuleiro.

---

## 🎯 Objetivos do Projeto

- Aplicar os conceitos de Programação Orientada a Objetos I (POOI) utilizando Java.
- Praticar princípios como:
  - Encapsulamento
  - Herança
  - Polimorfismo
  - Abstração
- Desenvolver um jogo interativo no console.

---

## 🛠️ Tecnologias Utilizadas

- 💻 Linguagem: **Java** 
- 🏗️ Ambiente de desenvolvimento: **IntelliJ IDEA**, **Eclipse**, **VSCode** ou outro.
- 🖥️ Execução via terminal ou pela própria IDE.

---

## 📂 Estrutura de Diretórios

```

batalha-naval/
├── src/
│   ├── jogo/
│   │   ├── Main.java          # Classe principal - ponto de entrada do programa
│   │   ├── Jogo.java          # Lógica principal do jogo
│   │   ├── Tabuleiro.java     # Representação do tabuleiro
│   │   ├── Embarcacao.java    # Classe abstrata para embarcações
│   │   ├── Navio.java         # Subclasse de Embarcacao (Navios específicos)
│   │   ├── Jogador.java       # Lógica dos jogadores (Humano e Computador)
│   │   └── Utils.java         # Métodos auxiliares (opcional)
├── README.md
└── ...

````

---

## 🎮 Regras do Jogo

* Cada jogador possui um tabuleiro onde posiciona suas embarcações.
* As embarcações têm tamanhos variados.
* O jogo alterna turnos entre os **Jogadores**.
* Cada turno consiste em escolher uma coordenada para atacar.
* O sistema informa se o ataque foi:

  * 💥 **Acerto**
  * 🌊 **Erro (água)**
  * 🚢 **Afundou um navio**
* O vencedor é aquele que destruir todas as embarcações do oponente primeiro.

---

## 🔥 Funcionalidades Implementadas

* 📜 Menu inicial
* 🚢 Posicionamento de navios manual ou aleatório
* 🎯 Sistema de ataque com feedback visual (console).
* 🔥 Marcação de acertos, erros e navios afundados no tabuleiro
* 🔁 Opção de reiniciar o jogo após uma partida
* 💡 Interface de texto simples e intuitiva no console

---

## 🧠 Conceitos de POO Aplicados

* **Encapsulamento:**

  * Uso de modificadores de acesso (`private`, `public`) para proteger dados.
* **Herança:**

  * A classe abstrata `Embarcacao` é estendida por classes específicas como `Navio`.
* **Polimorfismo:**

  * Métodos sobrescritos nas subclasses para se comportarem de formas específicas dependendo do tipo de embarcação.
* **Abstração:**

  * Divisão do sistema em classes que representam claramente os elementos do jogo (Jogador, Tabuleiro, Embarcação, etc.).

---

## 👨‍🏫 Informações Acadêmicas

* 📚 Disciplina: **Programação Orientada a Objetos I**
* 🎓 Curso: **Ciência da Computação**
* 🏫 Instituição: **Unicentro Câmpus Cedeteg**
* 👨‍🏫 Professor(a): **Inali Wisniewski Soares**
* 📅 Semestre: **3º Período**

---

## 👨‍💻 Autores

* [Patrick Moraes](https://github.com/patr0ka)
* [Ruan Pablo](https://github.com/Ruanrpm)
* [Pedro Castello](https://github.com/phcastello)

---

## 📄 Licença

Este projeto é de uso acadêmico e não possui fins comerciais.
