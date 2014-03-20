package cn.hdtmedia.report.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.alibaba.fastjson.annotation.JSONField;


@Entity
@Table(name = "hdt_dataSource")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class DataSourceTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;


	//@JSONField(serialize=false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id",unique=true, nullable = false)
	private long id;
	
	@Column(name = "_name", nullable = false)
	private String name;
	
	@JSONField(serialize=false)
	@Column(name = "_tableName", nullable = false)
	private String tableName;
	
	@JSONField(serialize=false)
	@Column(name = "_asName", nullable = false)
	private String asName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dataSourceTemp")
	@OrderBy("id asc")
	private Set<DimensionTemp> dimensionTemps;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dataSourceTemp")
	@OrderBy("id asc")
	private Set<IndicatorTemp> indicatorTemps;

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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getAsName() {
		return asName;
	}

	public void setAsName(String asName) {
		this.asName = asName;
	}

	public Set<DimensionTemp> getDimensionTemps() {
		return dimensionTemps;
	}

	public void setDimensionTemps(Set<DimensionTemp> dimensionTemps) {
		this.dimensionTemps = dimensionTemps;
	}

	public Set<IndicatorTemp> getIndicatorTemps() {
		return indicatorTemps;
	}

	public void setIndicatorTemps(Set<IndicatorTemp> indicatorTemps) {
		this.indicatorTemps = indicatorTemps;
	}
	
}
