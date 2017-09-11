package org.codingpedia.demo.rest.service.integration;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.codingpedia.demo.rest.dao.PodcastDao;
import org.codingpedia.demo.rest.dao.impl.PodcastDaoJPA2Impl;
import org.codingpedia.demo.rest.entities.Podcast;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDaoJPA2Impl {

	    static final String USER_ID = "test_id";
	    static final String PASSWORD = "test_password";
	    static final String INVALID_USER_ID = "test_user";

	    private EntityManagerFactory emf;
	    private EntityManager em;

	    @Before
	    public void setUp() {
	        emf = Persistence.createEntityManagerFactory("demoRestPersistence");
	        em = emf.createEntityManager();
	        createTestData();
	    }

	    @After
	    public void tearDown() {
	        if (em != null) {
	            removeTestData();
	            em.close();
	        }
	        if (emf != null) {
	            emf.close();
	        }
	    }

	    private void createTestData() {
	        Podcast podcast = new Podcast();
	        podcast.setId(new Long(1000));
	        podcast.setTitle(PASSWORD);
	        em.getTransaction().begin();
	        em.persist(podcast);
	        em.getTransaction().commit();
	    }

	    private void removeTestData() {
	        em.getTransaction().begin();
	        Podcast user = em.find(Podcast.class, 1000);
	        if (user != null) {
	            em.remove(user);
	        }
	        em.getTransaction().commit();
	    }

	    @Test
	    public void testAuthenticateValidUser() throws Exception {
//	        UserService service = new UserService();
//	        service.em = em;
//	        User user = service.authenticate(USER_ID, PASSWORD);
//	        Assert.assertNotNull(user);
//	        Assert.assertEquals(USER_ID, user.getName());
//	        Assert.assertEquals(PASSWORD, user.getPassword());
	    	
	    	PodcastDao podcastDao = new PodcastDaoJPA2Impl();
	    	List<Podcast> podcastList = podcastDao.getPodcasts();
	    	System.out.println("List podcast size: " + podcastList.size());
	    }
//	    @Test
//	    public void testAuthenticateInvalidUser() throws Exception {
//	        UserService service = new UserService();
//	        service.em = em;
//	        User user = service.authenticate(INVALID_USER_ID, PASSWORD);
//	        Assert.assertNull(user);
//	    }
	}
