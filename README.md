# README

## Descrição do Arquivo [`model.yml`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "d:\PUC\Semestre 7\Simulação e Metodo Analiticos\simulacaoT1\model.yml")

O arquivo [`model.yml`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "d:\PUC\Semestre 7\Simulação e Metodo Analiticos\simulacaoT1\model.yml") é utilizado para configurar os parâmetros de simulação de um sistema de filas. Ele define os intervalos de tempo para chegadas e passagens, bem como as características das filas (queues) envolvidas na simulação.

### Estrutura do Arquivo

O arquivo está dividido em duas seções principais: `intervals` e [`queues`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A14%2C%22character%22%3A0%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition").

### Seção `intervals`

Esta seção define os intervalos de tempo para diferentes eventos na simulação. Cada intervalo possui um tempo de início ([`start`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A2%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition")) e um tempo de fim ([`end`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A3%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition")).

- **arrivalInterval**: Intervalo de tempo para chegadas.
  - [`start`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A2%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 1.0
  - [`end`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A3%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 3.0

- **intervalQ1**: Intervalo de tempo para a fila Q1.
  - [`start`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A2%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 5
  - [`end`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A3%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 6

- **intervalQ2**: Intervalo de tempo para a fila Q2.
  - [`start`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A2%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 2
  - [`end`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A3%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 4

### Seção [`queues`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A14%2C%22character%22%3A0%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition")

Esta seção define as características das filas envolvidas na simulação. Cada fila possui um número de servidores ([`servers`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition")), uma capacidade máxima ([`capacity`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A17%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition")) e um intervalo de tempo associado ([`interval`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A18%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition")).

- **Q1**: Configuração da fila Q1.
  - [`servers`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 2 (número de servidores)
  - [`capacity`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A17%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 4 (capacidade máxima)
  - [`interval`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A18%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): intervalQ1 (intervalo de tempo associado)

- **Q2**: Configuração da fila Q2.
  - [`servers`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 3 (número de servidores)
  - [`capacity`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A17%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 5 (capacidade máxima)
  - [`interval`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A18%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): intervalQ2 (intervalo de tempo associado)

### Comentários

O arquivo também contém algumas configurações comentadas que podem ser ativadas conforme necessário:

- **intervalQ3**: Intervalo de tempo para uma fila adicional (Q3).
  - [`start`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A2%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 5
  - [`end`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A3%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 15

- **Q3**: Configuração da fila Q3.
  - [`servers`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 2 (número de servidores)
  - [`capacity`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A17%2C%22character%22%3A4%7D%7D%5D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "Go to definition"): 10 (capacidade máxima)

### Exemplo de Uso

Para utilizar este arquivo de configuração, basta descomentar as seções necessárias e ajustar os parâmetros conforme a necessidade da simulação.

```yaml
# Exemplo de como descomentar e ajustar a configuração para Q3
intervals:
  intervalQ3:
    start: 5
    end: 15

queues:
  Q3:
    servers: 2
    capacity: 10
    interval: intervalQ3
```

Este arquivo [`model.yml`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2FD%3A%2FPUC%2FSemestre%207%2FSimula%C3%A7%C3%A3o%20e%20Metodo%20Analiticos%2FsimulacaoT1%2Fmodel.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%223516e184-d122-485b-8158-95d80aad68af%22%5D "d:\PUC\Semestre 7\Simulação e Metodo Analiticos\simulacaoT1\model.yml") é essencial para definir os parâmetros de simulação de forma clara e organizada, permitindo ajustes rápidos e precisos conforme os requisitos do sistema de filas.