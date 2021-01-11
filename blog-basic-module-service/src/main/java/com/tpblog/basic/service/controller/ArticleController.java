package com.tpblog.basic.service.controller;

import com.tpblog.basic.api.entity.pojo.Article;
import com.tpblog.basic.api.entity.vo.ArticleVO;
import com.tpblog.basic.api.entity.vo.PageVO;
import com.tpblog.basic.api.service.ArticleService;
import com.tpblog.basic.service.utils.DozerConvertUtil;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 根据Id查询文章
     * @param id
     * @return
     */
    @GetMapping("find/{id}")
    public Article findArticleById(@PathVariable("id") Integer id){
        return articleService.findArticleById(id);
    }

    /**
     * 查询所有文章
     * @return
     */
    @GetMapping("find/all")
    public List<ArticleVO> findArticleAll(){
        List<Article> articleAll = articleService.findArticleAll();
        List<ArticleVO> articleVOS = DozerConvertUtil.transToList(articleAll, ArticleVO.class);
        return articleVOS;
    }

    /**
     * 分页查询相关文章
     * @param start
     * @param pageNum
     * @return
     */
    @GetMapping("find/{start}/{pageNum}")
    public PageVO findArticleByPage(@PathVariable("start") Integer start,
                                          @PathVariable("pageNum") Integer pageNum){
        if (start==null || pageNum==null) {
            start = 1;
            pageNum = 10;
        }
        Integer allPage = (int) Math.ceil((double)articleService.findArticleNums()/pageNum);
        System.out.println(allPage);
        if (allPage<start){
            start=allPage;
        }
        List<Article> articleByPage = articleService.findArticleByPage((start-1)*pageNum, pageNum);
        List<ArticleVO> articleVOS = DozerConvertUtil.transToList(articleByPage,ArticleVO.class);
        PageVO pageVO = new PageVO();
        pageVO.setData(articleVOS);
        pageVO.setPageNum(pageNum);
        pageVO.setStart(start);
        pageVO.setAllPage(allPage);
        pageVO.setHasNextPage(start < allPage);
        return pageVO;
    }
}
