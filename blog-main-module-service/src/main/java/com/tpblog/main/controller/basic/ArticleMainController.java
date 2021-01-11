package com.tpblog.main.controller.basic;

import com.tpblog.basic.api.entity.pojo.Article;
import com.tpblog.basic.api.entity.vo.ArticleVO;
import com.tpblog.basic.api.entity.vo.PageVO;
import com.tpblog.main.api.response.Result;
import com.tpblog.main.api.response.ResultUtil;
import com.tpblog.main.service.basic.ArticleMainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("main")
@Api(tags = "ArticleMainController",description = "文章增删改查等")
public class ArticleMainController {

    @Autowired
    private ArticleMainService articleMainService;

    @GetMapping("article/find/{id}")
    @ApiOperation(value = "根据文章Id查询文章",notes = "根据文章Id查询文章")
    public Result findArticleById(@PathVariable("id") Integer id){
        Article articleById = articleMainService.findArticleById(id);
        return ResultUtil.success(articleById);
    }

    @GetMapping("article/find/all")
    @ApiOperation(value = "查询所有文章")
    public Result findArticleAll(){
        List<ArticleVO> articleAll = articleMainService.findArticleAll();
        return ResultUtil.success(articleAll);
    }

    @GetMapping("article/{start}/{pageNum}")
    public Result findArticleByPage(@PathVariable("start") Integer start,
                                    @PathVariable("pageNum") Integer pageNum){
        PageVO articleByPage = articleMainService.findArticleByPage(start, pageNum);
        return ResultUtil.success(articleByPage);
    }
}
