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

import com.bootspring.ecommerce.entity.Product;
import com.bootspring.ecommerce.entity.ProductCategory;

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

		// Disable methods for Product: PUT, POST and DELETE.
		config.getExposureConfiguration().forDomainType(Product.class)
				.withItemExposure((metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions));

		// Disable methods for ProductCategory: PUT, POST and DELETE.
		config.getExposureConfiguration().forDomainType(ProductCategory.class)
				.withItemExposure((metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions));

		// Call a internal helper method
		exposeIds(config);

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
