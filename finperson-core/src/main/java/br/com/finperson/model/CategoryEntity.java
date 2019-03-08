package br.com.finperson.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper=true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class CategoryEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Builder
	public CategoryEntity(Long id, String name) {
        super(id);     
        this.name = name;
    }
	
	@Column
	private String color;
	
	@Column
	private String icon;
	
	@Column
	private String name;
			
}
