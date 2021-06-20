package com.tistory.doit1.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tistory.doit1.domain.Posts;
import com.tistory.doit1.domain.PostsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
	private PostsRepository postsRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        System.out.println("xxx2");
        log.trace("trace : {}", "trace123");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error1");
        String[] splits = { "foo", "bar" };

        List list = new ArrayList<Object>();
        list.add("test");
        list.add("test1");
        log.info("The string was split into {}", list);

        Map<String, Object> map = new HashMap<>();
        map.put("a1", "aaa1");
        map.put("a2", "aaa2");

        list = new ArrayList<Posts>();
        Posts post = new Posts("a", "b", "c");
        log.error("{}", post.toString());
        list.add(post);

        log.info("The string was split into {}", (Object) splits);
        log.info("The string was split into {}", list);
        log.info("The string was split into {}", map);
        return "반갑습니다. doit111.tistory.com에 오신것을 환영합니다.";
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(Posts post) {
        // Posts post = new Posts("title", "content", "author");
        
       post = postsRepository.save(Posts.builder()
        .title("제목2")
        .content("내용2")
        .author("b088081@gmail.com")
        .build());

        // log.trace("post : {}", post);
        // postsRepository.save(post);

        List<Posts> postList = postsRepository.findAll();
        log.debug("postList : <{}>", postList);

        return post.toString();
    }


    /**  [TK Yoon(pro@dreamlabs.co.kr) 2021-06-18 13:46:27] */
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
	public List<Posts> list() {
    	List<Posts> helloList = postsRepository.findAll();
		return helloList;
	}

    
}