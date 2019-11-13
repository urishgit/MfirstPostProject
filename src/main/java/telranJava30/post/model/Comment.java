package telranJava30.post.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Comment {
String user;
@Setter
String message;
@JsonFormat(pattern =   "DD/MM/YYYY")
LocalDate createDate;
int likes;

public Comment(String message) {
	this.message = message;
	user="";
	createDate=LocalDate.now();
	
}

public int addlikes(int likes)
{
	return likes++;
}



}
