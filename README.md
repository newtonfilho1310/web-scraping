# Projeto de Web Scraping em Java

Este é um projeto simples para demonstrar os conceitos de Web Scraping (Raspagem de Dados) usando Java e a biblioteca [Jsoup](https://jsoup.org/).

## Funcionalidades Atuais (MVP)
- Permite que o usuário digite uma URL no terminal.
- Conecta-se ao site usando uma requisição HTTP `GET`.
- Analisa o HTML retornado.
- Extrai e limpa os dados (Ex: Título da página, links ou citações do site de testes `quotes.toscrape.com`).
- Imprime os dados organizados no console.

## Como evoluir o projeto no futuro?
Como descrito nos requisitos do projeto, futuramente podemos adicionar:
1. **Salvar em Banco de Dados:** Conectar ao MySQL, PostgreSQL ou SQLite para persistir os dados ao invés de apenas imprimi-los no terminal.
2. **Scrapes Automáticos:** Usar bibliotecas de agendamento (como Quartz Scheduler ou `@Scheduled` do Spring Boot) para rodar o scraper de hora em hora ou diariamente.
3. **Múltiplos sites:** Criar lógicas específicas para raspar diferentes tipos de sites (ex: pegar preços de produtos, notícias, etc).

## Como rodar?
Abra esta pasta (`c:\Dev\web-scraper`) em sua IDE (IntelliJ, Eclipse ou VS Code), aguarde o Maven baixar a biblioteca do Jsoup e rode a classe `App.java`.
