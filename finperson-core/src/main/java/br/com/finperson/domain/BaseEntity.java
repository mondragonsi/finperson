/**
 * 
 */
package br.com.finperson.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import br.com.finperson.domain.enumm.OperationEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Fred Brasil
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public BaseEntity(Long id) {
		super();
		this.id = id;
	}

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Enumerated
    private OperationEnum operation;
      
    @Column(name = "timestamp")
    private long timestamp;
    
	@Column
    @CreatedBy
    private String createdBy;
 
    @Column
    @LastModifiedBy
    private String modifiedBy;
    
    @PrePersist
    public void onPrePersist() {
        audit(OperationEnum.INSERT);
    }
      
    @PreUpdate
    public void onPreUpdate() {
        audit(OperationEnum.UPDATE);
    }
      
    @PreRemove
    public void onPreRemove() {
        audit(OperationEnum.DELETE);
    }
      
    private void audit(OperationEnum operation) {
        setOperation(operation);
        setTimestamp((new Date()).getTime());
    }
}
