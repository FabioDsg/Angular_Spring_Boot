package com.bootspring.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.bootspring.ecommerce.entity.Country;
import com.bootspring.ecommerce.entity.Product;
import com.bootspring.ecommerce.entity.ProductCategory;
import com.bootspring.ecommerce.entity.State;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	private EntityManager entityManager;

	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		// Temporarily disabling these methods
		HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE };

//		// Disable HTTP methods for ProductCategory: PUT, POST and DELETE
        disableHttpMethods(Product.class, config, theUnsupportedActions);
        disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);
        disableHttpMethods(Country.class, config, theUnsupportedActions);
        disableHttpMethods(State.class, config, theUnsupportedActions);

		// Call a internal helper method
		exposeIds(config);

	}
	
	 private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
	        config.getExposureConfiguration()
	                .forDomainType(theClass)
	                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
	                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	    }

	private void exposeIds(RepositoryRestConfiguration config) {
		// Expose entity id's
		
		
		// Get a list of all entity Classes from the entity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		// Create an array of the entity types
		List<Class> entityClasses = new ArrayList<>();
		
		// Get the entity types for the entities
		for (EntityType tempEntityType : entities) {
			
			entityClasses.add(tempEntityType.getJavaType());
		}
		
		// Expose the entity id's for the array of entity/domain types
		Class [] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
		
	}

}
