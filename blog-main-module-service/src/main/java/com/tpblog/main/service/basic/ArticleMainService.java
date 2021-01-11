package com.tpblog.main.service.basic;

import com.tpblog.basic.api.entity.pojo.Article;
import com.tpblog.basic.api.entity.vo.ArticleVO;
import com.tpblog.basic.api.entity.vo.PageVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "blog-basic-service",path = "article")
public interface ArticleMainService {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("find/{id}")
    Article findArticleById(@PathVariable("id") Integer id);

    /**
     * 查询所有文章
     * @return
     */
    @GetMapping("find/all")
    List<ArticleVO> findArticleAll();

    /**
     * 分页查询
     * @param start
     * @param pageNum
     * @return
     */
    @GetMapping("find/{start}/{pageNum}")
    PageVO findArticleByPage(@PathVariable("start") Integer start,
                                    @PathVariable("pageNum") Integer pageNum);
}
