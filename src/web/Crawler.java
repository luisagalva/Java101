package web;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	private static final Logger logger = LogManager.getLogger();	
	
	private final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_0) "
			+ "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36";
	private final String USER_AGENT;

	// Guarda el URL y dominio
	private final String url;
	private final String domain;

	// Registra paginas visitadas y links
	private Set<String> pageLinks = new HashSet<String>();
	private Set<String> pageVisited = new HashSet<String>();

	// Constructor con url
	public Crawler(String url) throws MalformedURLException {
		this.url = url;
		this.domain = obtainDomain();
		this.USER_AGENT = this.DEFAULT_USER_AGENT;
		crawl();
		
	}

	// Constructor con URL y user_agent
	public Crawler(String user_agent, String url) throws MalformedURLException{
		this.url = url;
		this.domain = obtainDomain();
		this.USER_AGENT = user_agent;
	}

	// Llama al método doCrawl
	public void crawl(){
		logger.info("Starting to crawl.");
		doCrawl(this.url);
	}

	// Método recursivo
	public void doCrawl(String url){
		Set<String> thisPageLinks = getLinks(url);
		pageVisited.add(url);
		
		for (String link: thisPageLinks){
			if (link.contains(this.domain) && !pageVisited.contains(link) && !link.contains("#")){
				logger.info("Subcrawling {}", link);
				doCrawl(link);
			} 
		}
		this.pageLinks.addAll(thisPageLinks);
	}
	
	// Obiene los links en un URL dado
	public Set<String> getLinks(String url){
		Set<String> links = new HashSet<String>();
		try {
			// 1. Obtiene los links de un URL específico y regresa el
			// set de strings
			// escribe aquí tu código {
			
			Document doc = Jsoup.connect(url).ignoreContentType(false).userAgent(USER_AGENT).get();
			
			Elements articles = doc.select("a");
			logger.info("Artículos encontrados: {}", articles.size());
			

			for (Element article: articles){
				// Accede al atributo de <a> href
				String link = article.attr("href");
				// Guarda los elementos en el HasMap
				
					links.add(link);	
		    } 
			return links;
			}catch(Exception io){
			logger.warn(io);
			return links;
		}
	} 
	
	// Obtiene el Dominio a partir del URL previamente asignado
	public String obtainDomain() throws MalformedURLException{
		// 2. Obtiene el dominio por medio de un URL asignando
		// escribe aquí tu código {
		  URI uri;
		try {
			uri = new URI(url);
			String domain = uri.getHost();
			return domain.startsWith("www.") ? domain.substring(4) : domain;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return domain.startsWith("www.") ? domain.substring(4) : domain;
		}
		    
		 
		// }
	}
	
	/*
	 * Getters & Setters
	 * */
	public String getDomain(){
		return this.domain;
	}
	

	public Set<String> getPageLinks() {
		return pageLinks;
	}

	public void setPageLinks(Set<String> pageLinks) {
		this.pageLinks = pageLinks;
	}

	public String getUrl() {
		return url;
	}

	public Set<String> getPageVisited() {
		return pageVisited;
	}

	public void setPageVisited(Set<String> pageVisited) {
		this.pageVisited = pageVisited;
	}
	
}
