package com.techleads.app.junit.article;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
//@AutoConfigureMockMvc
class ArticleDistributorTest {
//	Channel sport = mock(Channel.class);
//	Channel entertainment = mock(Channel.class);
//	Channel others = mock(Channel.class);
//	ArticleDataAccess dataAccess = mock(ArticleDataAccess.class);
	@Mock
	private Channel sport;
	@Mock
	private Channel entertainment;
	@Mock
	private Channel others;
	@Mock
	private ArticleDataAccess dataAccess;
//	@InjectMocks
//	private ArticleDistributor distributor;

	@Test
	void sportsGoestoSportsPoliticsGoestoOther() {

		ArticleDistributor distributor = new ArticleDistributor(sport, entertainment, others, dataAccess);
		List<Article> list = Arrays.asList(new Article("Sport is fun", Type.SPORT),
				new Article("Politics is sad", Type.POLITICS));

		when(dataAccess.getTodayArticles()).thenReturn(list);
		distributor.disributeTodays();

		verify(sport, times(1)).accept(any());
		verify(others, times(1)).accept(any());
		verify(entertainment, never()).accept(any());

	}

}
