package ca.sheridancollege.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name="Article.getAll", query="from Article")
public class Article {
	@Id
	@NotEmpty
	private String title;
	@ElementCollection
	@Valid
	private List<Section> sections = new ArrayList<Section>();
//	@ElementCollection
//	private List<Address> addressList = new ArrayList<Address>();
//	@OneToOne
//	private Vehicle vehicle;
	
	public Article(String title) {
		this.title = title;
	}
}
