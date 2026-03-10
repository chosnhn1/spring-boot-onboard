package com.asdf.minilog.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.asdf.minilog.service.ArticleService;
import com.asdf.minilog.service.FollowService;
import com.asdf.minilog.service.UserService;

@Controller
public class GraphQLMutationController {

    private final ArticleService articleService;
    private final FollowService followService;
    private final UserService userService;

    @Autowired
    public GraphQLMutationController(
        ArticleService articleService,
        FollowService followService,
        UserService userService
    ) {
        this.articleService = articleService;
        this.followService = followService;
        this.userService = userService;
    }

    
}
