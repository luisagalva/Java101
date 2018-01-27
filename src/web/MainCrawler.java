package web;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainCrawler {
	private static final Logger logger = LogManager.getLogger();
	private static final String APP_VERSION = "v1.0";
	
	public static void main(String[] args)  {
		System.out.format("Web Crawler Simple %s\n\n", APP_VERSION);
		try (Scanner scanner = new Scanner(System.in)){
			System.out.print("Sitio web a inspeccionar: ");
			// Sitio web a leer
			String webSite = scanner.nextLine();

			// 1. Crea instancia en webSiteCrawler Crawler de con el website
			// que se ingresó por el usuario previamente 
			// escribe aquí tu código {
			Crawler webSiteCrawler = new Crawler(webSite);
			
			
			/// }
			Set<String> links = webSiteCrawler.getPageLinks();

			// Imprime resumen
			System.out.println("Resumen");
			System.out.println("==========================");
			System.out.format("URL      : %s\n", webSiteCrawler.getUrl());
			System.out.format("Dominio  : %s\n", webSiteCrawler.getDomain());
			System.out.format("Visitados: %s\n", webSiteCrawler.getPageVisited().size());
			System.out.format("Links    : %s\n", links.size());
			System.out.println("==========================");
			
			System.out.println("Guardar resultados en archivo? Si/No");
			String guardarArchivo = scanner.nextLine();
			if (guardarArchivo.contains("Si") || guardarArchivo.contains("si")){
				String nombreArchivo = guardaArchivo(webSiteCrawler);
				System.out.format("Links guardados exitosamente en %s \n", nombreArchivo);
			}
		} catch (IOException e) {
			logger.error(e);
		} finally {
			System.out.println("Terminando programa.");
		}

	}

	private static String guardaArchivo(Crawler webSiteCrawler) throws IOException {
		// 2. Guardar el resultado en un archivo de texto con nombre del dominio
		// ej. http://jsoup.org el archivo es jsoup.org.txt
		// escribe aquí tu código {
		
		Set<String> links = webSiteCrawler.getPageLinks();
		
		Path name = Paths.get(webSiteCrawler.getDomain() + ".txt");
				
		try(BufferedWriter writer = Files.newBufferedWriter(name, StandardCharsets.UTF_8, StandardOpenOption.CREATE)){
		
			for(String link: links){
				writer.write( link+"\n");
					}
			}
		
		catch(IOException e){
			System.err.format("Error: ", e.getClass(), e.getMessage());
		}
		
		return name.toString();
		// }
	}
}
