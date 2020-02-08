package ca.sheridancollege.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Section {
	@NotEmpty
	String title;
	@Column(length=14000)
	@NotEmpty
	String content;
}
