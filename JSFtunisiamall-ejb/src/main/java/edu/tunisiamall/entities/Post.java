package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPost;

	private String description;

	private String title;

	private int rating;

	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;

	@OneToMany(mappedBy = "post")
	private List<Comment> comments;

	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;

	@ManyToOne
	@JoinColumn(name = "idTopic")
	private Topic topic;

	public Post() {
	}

	public int getIdPost() {
		return this.idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setPost(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setPost(null);

		return comment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public int hashCode() {
		return idPost;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Post))
			return false;
		Post other = (Post) obj;
		if (idPost != other.idPost)
			return false;
		return true;
	}

}