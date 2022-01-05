package eus.uni.dam;

import java.util.Properties;
import javax.sql.DataSource;

import com.NewTel.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:/application.properties")
@EnableTransactionManagement
public class DatuBasearenKonfigurazioa_Postgres {

	/**
	 * Postgres datubaseko DataSource definitzea gure datu-basera konektatzeko. Propietateak propertie-en fitxategitik ezartzen dira,
	 * eta esleitu egiten dira Env Objektua erabiliz
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();	//Env objetuari propietateak ezartzen dio
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	}

	/**
	 *
	 * EntityManagerFactory de JPA ren konfigurazioa
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		// Le asignamos el dataSource que acabamos de definir.
		entityManagerFactory.setDataSource(dataSource());

		// Le indicamos la ruta donde tiene que buscar las clases anotadas
		entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));

		// Implementación de JPA a usar: Hibernate
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

		// Propiedades de Hibernate
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		additionalProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		entityManagerFactory.setJpaProperties(additionalProperties);

		return entityManagerFactory;
	}

	/**
	 * Inicializa y declara el gestor de transacciones
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
		return transactionManager;
	}

	/**
	 * 
	 * Este bean es un postprocessor que ayuda a relanzar las excepciones
	 * específicas de cada plataforma en aquellas clases anotadas con @Repository
	 *
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public ResPartnerDao getResPartnerDao() {
		return new ResPartnerDao();
	}

	@Bean
	public PartidakDao getPartidakDao(){return new PartidakDao();}

	@Bean
	public RunHelper getRunHelper(){return new RunHelper();}

	@Autowired
	private Environment env;

	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;

}