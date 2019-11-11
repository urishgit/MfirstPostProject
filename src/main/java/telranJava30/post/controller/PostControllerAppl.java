package telranJava30.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import telranJava30.post.dto.PostDto;
import telranJava30.post.model.Comment;
import telranJava30.post.model.Post;
import telranJava30.post.service.PostService;

@Controller
public class PostControllerAppl {
	@Autowired
	PostService postService;
	
@PostMapping("/forum/post/{auther}")
public Post addPost( @RequestBody Post post,@PathVariable  String auther)
{
	return postService.addPost(post, auther);
}
@GetMapping("/forum/post/{id}")
public Post findPostById(@PathVariable String id)
{
	return postService.findPostById(id);
}
@DeleteMapping("/forum/post/{id}")
public Post deletePost(  @PathVariable String id)
{
	return postService.deletePost(id);
}
@PutMapping("/forum/post/{id}")
public Post updatePost(@PathVariable String id,@RequestBody PostDto postdto)
{
	return postService.updatePost(id, postdto);
}
@PutMapping("/forum/post/{id}/like")
public Post addLike(@PathVariable String id)
{
	return postService.addLike(id);
}
@PutMapping("/forum/post/{id}/comment/{auther}")
public Post addComment(@PathVariable String id,@PathVariable String auther,@RequestBody Comment comment)
{
	return postService.addComment(id, auther, comment);
}
@GetMapping("/forum/post/auther/{auther}")
public Post findPostByAuther(@PathVariable  String auther)
{
	return postService.findPostByAuther(auther);
}
}
