package cn.hdtmedia.report.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.alibaba.fastjson.annotation.JSONField;


@Entity
@Table(name = "hdt_dimensionex")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class DimensionExTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "_name", nullable = false)
	private String name;
	
	@JSONField(serialize=false)
	@Column(name = "_propertyName", nullable = false)
	private String propertyName;
	
	@JSONField(serialize=false)
	@Column(name = "_asName")
	private String asName;
	
	@Column(name = "_isrequired", nullable = false)
	private boolean isRequired;
	
	@JSONField(serialize=false)
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "dimension_id")
	private DimensionTemp dimensionTemp;
	
	
//	@Column(name = "_isredio", nullable = false)
//	private boolean isRedio;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}	

	public String getAsName() {
		return asName;
	}

	public void setAsName(String asName) {
		this.asName = asName;
	}

	public DimensionTemp getDimensionTemp() {
		return dimensionTemp;
	}

	public void setDimensionTemp(DimensionTemp dimensionTemp) {
		this.dimensionTemp = dimensionTemp;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

//	public boolean isRedio() {
//		return isRedio;
//	}
//
//	public void setRedio(boolean isRedio) {
//		this.isRedio = isRedio;
//	}
	

}
