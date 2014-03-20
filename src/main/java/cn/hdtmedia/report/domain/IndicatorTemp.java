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
@Table(name = "hdt_indicator")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class IndicatorTemp implements Serializable {
	
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
	@Column(name = "_asName", nullable = false)
	private String asName;
	
	@JSONField(serialize=false)
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "dataSource_id")
	private DataSourceTemp dataSourceTemp;

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

	public DataSourceTemp getDataSourceTemp() {
		return dataSourceTemp;
	}

	public void setDataSourceTemp(DataSourceTemp dataSourceTemp) {
		this.dataSourceTemp = dataSourceTemp;
	}
	
	
	
	

}
