package telranJava30.post.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import telranJava30.post.dto.PostDto;
import telranJava30.post.model.Comment;
import telranJava30.post.model.Post;

public interface PostService {
	public Post addPost( @RequestBody PostDto postDto,@PathVariable  String auther);
	
	
	public Post findPostById(@PathVariable String id);

	
	public Post deletePost(  @PathVariable String id);
	
	
	public Post updatePost(@PathVariable String id,@RequestBody PostDto postdto);
	
	public Post addLike(@PathVariable String id);
	
	public Post addComment(@PathVariable String id,@PathVariable String auther,@RequestBody Comment comment);
	
	public Post findPostByAuther(@PathVariable  String auther);
	
}
