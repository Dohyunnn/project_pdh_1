package com.kor.exam.demo.reporsitory;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kor.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {
	// INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = ?, `body` = ?;
	public Article writeArticle(String title, String body);
	
	// SELECT * FROM article WHERE id = ?
	@Select("SELECET * FROM article where id = #{id}")
	public Article getArticle(@Param("id") int id);

	// DLETE FROM article WHERE id = ?
	@Delete("DELETE FROM article WHERE id = (id)")
	public void deleteArticle(int id);

	// UPDATE article SET title = ?, `body` = ?, updateDate = NOW() WHERE id = ?;
	@Update("UPDATE article SET title =#{title}, 'body' = #{boy}, updateDate = NOW() WHERE id = #{id}")
	public void modifyArticle(int id, String title, String body);

	// SELECT * FROM article ORDER BY id DESC;
	@Select("SELECT * FROM article ORDER BY id DESC")
	public List<Article> getArticles();
}


