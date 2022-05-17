package com.wcs.dockerspring.article;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcs.dockerspring.controller.ArticleController;
import com.wcs.dockerspring.entity.Article;
import com.wcs.dockerspring.repository.ArticleRepository;

@WebMvcTest(controllers = ArticleController.class)
class ArticleTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ArticleRepository articleRepository;
	
	@Autowired
	private ObjectMapper objectMapper;

	
	@Test
    void testGetArticles() throws Exception {
        mockMvc.perform(get("/articles"))
            .andExpect(status().isOk());
    }
	@Test
	void insertArticle() throws Exception {
		Article article = new Article();
		article.setTitle("Mon titre");
		article.setDescription("deeeescription");

		mockMvc.perform(post("/articles")
        		.contentType("application/json")
        		.content(objectMapper.writeValueAsString(article)))
            .andExpect(status().isOk());
    }

}
