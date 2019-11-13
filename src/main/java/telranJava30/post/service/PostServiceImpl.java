package telranJava30.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telranJava30.post.dau.PostRepository;
import telranJava30.post.dto.PostDto;
import telranJava30.post.dto.PostNotExists;
import telranJava30.post.dto.PostNotExistsByAuther;
import telranJava30.post.model.Comment;
import telranJava30.post.model.Post;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository repository;
	

	@Override
	public Post addPost(PostDto postDto, String auther) {
		Post post=findPostByAuther(auther);
			List<String>res=post.addTaGList(postDto.getTags());
			post=new Post(postDto.getTitle(), postDto.getContent(), res);		
	return repository.save(post);
	}

	@Override
	public Post findPostById(String id) {
		Post post=repository.findById(id).orElse(null);
		if(post==null)
		{
			throw new PostNotExists(id);
		}
		return post;
	}

	@Override
	public Post deletePost(String id) {
		Post post=repository.findById(id).orElse(null);
		if(post==null)
		{
			throw new PostNotExists(id);
		}
		repository.delete(post);
		return post;
	}

	@Override
	public Post updatePost(String id, PostDto postdto) {
	Post post=repository.findById(id).orElse(null);
	if(post==null)
	{
		throw new PostNotExists(id);
	}
	if(postdto.getTitle()!=null)
	{
		post.setTitle(postdto.getTitle());
	}
	if(postdto.getContent()!=null)
	{
		post.setContent(postdto.getContent());
	}
     if(postdto.getTags()!=null)
     {
    	 List<String>resList=post.addTaGList(postdto.getTags());
    	 post.setTags(resList);
     }
		return repository.save(post);
	}

	@Override
	public Post addLike(String id) {
		Post post=repository.findById(id).orElse(null);
		if(post==null)
		{
			throw new PostNotExists(id);
		}
		int likes=post.addlike(1);
		post.setLikes(likes);
		return repository.save(post);
	}

	@Override
	public Post addComment(String id, String auther, Comment comment) {
		Post post=repository.findById(id).orElse(null);
		if(post==null) {
			throw new PostNotExists(id);
		}
		post.setAuther(auther);
		post.addComment(comment);
		return post;
	}

	@Override
	public Post findPostByAuther(String auther) {
		Post post=repository.findByAuther(auther);
		if(post == null)
		{
			throw new PostNotExistsByAuther(auther);
		}
		
		return post;
	}

}
