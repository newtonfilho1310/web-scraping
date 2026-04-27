package br.com.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Bem-vindo ao Web Scraper em Java! ===");
        System.out.println("Este projeto usa a biblioteca Jsoup para extrair dados de sites HTML.\n");
        
        System.out.print("Digite a URL do site que deseja extrair (ex: https://quotes.toscrape.com/): ");
        String url = scanner.nextLine();
        
        // Se o usuário apenas apertar Enter, usamos um site padrão de testes de raspagem
        if (url == null || url.trim().isEmpty()) {
            System.out.println("URL vazia. Usando site padrão de testes...");
            url = "https://quotes.toscrape.com/";
        } else if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        try {
            System.out.println("\nConectando a " + url + "...");
            
            // Faz a requisição HTTP GET para a URL e obtém todo o HTML da página
            Document document = Jsoup.connect(url).get();
            
            // Exemplo de limpeza: pegando apenas o título da página (sem as tags HTML)
            String title = document.title();
            System.out.println("=========================================");
            System.out.println("Título da Página: " + title);
            System.out.println("=========================================\n");

            // Exemplo específico: Se for o site de testes (quotes.toscrape.com)
            if (url.contains("quotes.toscrape.com")) {
                // Buscamos elementos no HTML usando seletores CSS (igual fazemos no CSS do front-end)
                Elements quotes = document.select(".quote");
                System.out.println("Encontradas " + quotes.size() + " citações na página inicial:\n");
                
                for (Element quote : quotes) {
                    // Extrai apenas o texto de dentro da classe .text e .author
                    String text = quote.select(".text").text();
                    String author = quote.select(".author").text();
                    
                    System.out.println("Autor: " + author);
                    System.out.println("Citação: " + text);
                    System.out.println("-----------------------------------------");
                }
            } else {
                // Para outros sites, tentamos achar todos os links da página para demonstração
                Elements links = document.select("a[href]");
                System.out.println("Encontrados " + links.size() + " links na página.");
                System.out.println("Mostrando os 5 primeiros links encontrados:");
                
                int count = 0;
                for (Element link : links) {
                    if (count >= 5) break;
                    // abs:href pega a URL completa, mesmo que o link no HTML seja relativo (/pagina-2)
                    System.out.println("- " + link.text() + " -> " + link.attr("abs:href"));
                    count++;
                }
            }
            
            System.out.println("\n✅ Extração finalizada com sucesso!");
            
        } catch (IOException e) {
            System.err.println("❌ Erro ao conectar ou extrair dados do site: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
