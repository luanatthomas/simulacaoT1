# README

## Descrição do Arquivo `model.yml`

O arquivo `model.yml` é utilizado para configurar os parâmetros de simulação de um sistema de filas. Ele define os intervalos de tempo para chegadas e passagens, bem como as características das filas (queues) envolvidas na simulação.

### Estrutura do Arquivo

O arquivo está dividido em três seções principais: `intervals`, `queues` e `routing`

## Intervals:

Esta seção define os intervalos de tempo para diferentes eventos na simulação. Cada intervalo possui uma declaração de nome, seguido de um tempo de início (`start`) e um tempo de fim (`end`).

```
intervals:
  arrivalInterval:
    start: 2.0
    end: 4.
  intervalQ1:
    start: 1
    end: 2
  intervalQ2:
    start: 4
    end: 8
```

## Queues:

Esta seção define as características das filas envolvidas na simulação. Cada fila possui uma declaração de identificados, seguido de um número de servidores (`servers`), uma capacidade máxima (`capacity`) - para capacidade infinita, deixar em branco - e um intervalo de tempo associado (`interval`).

```
queues:
  Q1:
    servers: 1
    capacity:
    interval: intervalQ1
  Q2:
    servers: 2
    capacity: 5
    interval: intervalQ2
```

## Routing:

Esta seção define os roteamentos entre as filas. Abaixo da declaração de identificador de cada fila, indicamos para qual fila pode ser roteado, e qual a probabilidade. Quando fila = Q-1, significa que essa é a probabilidade de sair da simulação

```
routing:
  Q1:
    Q2: 1
  Q2:
    Q1: 0.3
    Q-1: 0.7
```

## Últimos ajustes

Definição do intervalo de chegada, tempo inicial e fila inicial

```
arrivalInterval: arrivalInterval
startTime: 2
startQueue: Q1
```

## Passos para executar o simulador:

1. **Compilar os arquivos:**

   Compilar a lib `snakeyaml-1.30.jar` e os arquivos `.java` para dentro da pasta `src/`:

   ```bash
   javac -cp "lib/*" -d bin src/*.java
   ```

2. **Executar a classe App:**

   Executar a classe `App` com o caminho do arquivo `.yml`:

   ```bash
   (windows) java -cp "bin;lib/*" App ./model.yml
    ou
   (linux) java -cp "bin:lib/*" App ./model.yml
   ```
