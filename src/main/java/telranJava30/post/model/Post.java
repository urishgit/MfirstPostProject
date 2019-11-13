package telranJava30.post.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = "id")
@Document(collation = "posts")
@Builder
public class Post {
	@Id
String id;
	@Setter
String title;
	@Setter
String content;
	@Setter
String auther;
	@JsonFormat(pattern =   "DD/MM/YYYY")
LocalDate created;
@Setter
List<String>tags;
@Setter
int likes;
@Setter
List<Comment>comments;

public Post( String title, String content, List<String> list) {
	
	this.title = title;
	this.content = content;
this.tags=new ArrayList<String>();
	comments =new ArrayList<>();
	auther=null;
	likes=getLikes();
	created=LocalDate.now();
}

public int addlike(int likes)
{
	return likes++;
}

public List<Comment>  addComment(Comment comment)
{
	comments.add(comment);
    return comments;
}
public List<String>addTaGList(String tag)
{
	tags.add(tag);
	return tags;
}

public Post(String id, String title, String content, String auther, LocalDate created, List<String> tags, int likes,
		List<Comment> comments) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.auther = auther;
	this.created = created;
	this.tags = tags;
	this.likes = likes;
	this.comments = comments;
}
}
