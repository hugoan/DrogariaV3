package br.com.drogariav3.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();
	
	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}
	
	private static SessionFactory criarFabricaDeSessoes(){
		 try {
	            Configuration configuracao = new Configuration().configure();
	            
	            ServiceRegistry registro = new StandardServiceRegistryBuilder()
	            	.applySettings(configuracao.getProperties()).build();
	            
	            SessionFactory fabrica = configuracao.buildSessionFactory(registro);
	            
	            return fabrica;
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("A fabrica de sessões não pode ser criada." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	}

}
