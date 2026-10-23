# VegeTrack - Gestão de Áreas Verdes em Rodovias 🌿🛣️

Este projeto é um Produto Mínimo Viável (MVP) desenvolvido nativamente em Android (Kotlin/XML) para a **Sprint 4**. O objetivo da aplicação é permitir o acompanhamento da evolução da vegetação ao longo do tempo e identificar o momento ideal para intervenções nas áreas operadas pela Motiva.

## 🚀 Evolução da Sprint 4
Nesta etapa, o projeto foi reestruturado para um ambiente profissional, garantindo:
* **Arquitetura Desacoplada:** O código foi dividido em pacotes (`ui`, `domain`, `data`), separando a interface visual das regras de negócio e acesso a dados.
* **Persistência de Dados:** Implementação do `TrechoRepository` utilizando `SharedPreferences` e `Gson` (JSON) para salvar e recuperar os dados localmente. As informações são mantidas mesmo após o encerramento da aplicação.
* **Gerenciamento de Estados:** Utilização de `ViewModel` e `LiveData` para controlar os fluxos de `UiState` (Carregando, Sucesso, Erro), evitando crashes e fornecendo feedback visual amigável ao utilizador.

## 📱 Funcionalidades
* **Dashboard de Trechos:** Apresentação em lista (RecyclerView) dos trechos de rodovia monitorizados, lidos diretamente da persistência local.
* **Navegação de Detalhes:** Ecrã que apresenta informações detalhadas sobre a taxa de crescimento da vegetação com passagem de parâmetros seguras (Intent).
* **Registo de Ação:** Botão interativo para iniciar o registo de manutenção.

## 🎥 Demonstração do Projeto
🔗 [Vídeo no YouTube - Demonstração da Sprint 4](https://youtu.be/wgMaHO-tWp0)

### 📝 Transcrição / Legenda do Vídeo
Caso prefira acompanhar em texto, aqui está o roteiro do que é demonstrado no vídeo:

* **[00:00 - 00:14] Introdução e Arquitetura:** "Olá, este é o vídeo de entrega da Sprint 4 do VegeTrack. Na estrutura do projeto à esquerda, podem ver que implementámos a arquitetura desacoplada dividindo o código nas pastas `data`, `domain` e `ui`, separando completamente a interface das regras de negócio."
* **[00:15 - 00:22] Gerenciamento de Estados:** "Ao abrirmos a aplicação no emulador, reparem na mensagem 'A carregar os dados da rodovia...'. Este é o nosso `TrechoViewModel` em ação, gerindo os estados de 'Carregando' e 'Sucesso' para proteger a aplicação contra falhas de execução antes de os dados estarem prontos."
* **[00:23 - 00:32] Funcionalidade e Navegação:** "O fluxo de navegação mantém-se robusto. Ao clicar num trecho, os dados são passados via Intent para o ecrã de detalhes. O botão de manutenção aciona o evento corretamente e regressamos à lista de forma fluida."
* **[00:33 - 01:15] Persistência de Dados e Código:** "Para garantir a persistência, criámos o `TrechoRepository`, que utiliza `SharedPreferences` e `Gson` para converter e salvar a lista localmente. Assim, mesmo fechando o aplicativo, os dados não se perdem. Toda a lógica de observação de estado ocorre na `MainActivity`, mantendo o código XML da interface limpo e focado apenas na apresentação visual."

## 🎨 Protótipo e Design
🔗 [Acessar o Protótipo no Figma](https://www.figma.com/make/TZbxhvHUhf8iVRyR3W8QKd/Prototipo_Sprint01?t=hubEO5cSC8UjsOFf-1)

## 👥 Integrantes do Grupo
* Arthur Traldi Felix - RM563477
* Vitor Barbosa de Paiva - RM565303
* Lucas Andrade Souza - RM564066
* Luis Otavio Santini Feitosa - RM563556
