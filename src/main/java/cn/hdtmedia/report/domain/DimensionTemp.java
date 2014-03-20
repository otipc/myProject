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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.alibaba.fastjson.annotation.JSONField;


@Entity
@Table(name = "hdt_dimension")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class DimensionTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "_name", nullable = false)
	private String name;
	
	@JSONField(serialize=false)
	@Column(name = "_tableName", nullable = false)
	private String tableName;
	
	@JSONField(serialize=false)
	@Column(name = "_asName", nullable = false)
	private String asName;
	
	@JSONField(serialize=false)
	@Column(name = "_propertyName", nullable = false)
	private String propertyName;
	
	@JSONField(serialize=false)
	@Column(name = "_idName", nullable = false)
	private String idName;			
	
	@Column(name = "_isrequired", nullable = false)
	private boolean isRequired;
	
	@Column(name = "_isradio", nullable = false)
	private boolean isRadio;
		
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dimensionTemp")
	@OrderBy("id asc")
	private Set<DimensionExTemp> DimensionExTemps;
	
	@JSONField(serialize=false)
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "dataSource_id")
	private DataSourceTemp dataSourceTemp;
	
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "DimensionTemp")
//	private SelDimension selDimension;


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


	public String getPropertyName() {
		return propertyName;
	}


	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getIdName() {
		return idName;
	}


	public void setIdName(String idName) {
		this.idName = idName;
	}


	public DataSourceTemp getDataSourceTemp() {
		return dataSourceTemp;
	}


	public void setDataSourceTemp(DataSourceTemp dataSourceTemp) {
		this.dataSourceTemp = dataSourceTemp;
	}


	public boolean isRequired() {
		return isRequired;
	}


	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}		

	public boolean isRadio() {
		return isRadio;
	}


	public void setRadio(boolean isRadio) {
		this.isRadio = isRadio;
	}


	public Set<DimensionExTemp> getDimensionExTemps() {
		return DimensionExTemps;
	}


	public void setDimensionExTemps(Set<DimensionExTemp> dimensionExTemps) {
		DimensionExTemps = dimensionExTemps;
	}


//	public SelDimension getSelDimension() {
//		return selDimension;
//	}
//
//
//	public void setSelDimension(SelDimension selDimension) {
//		this.selDimension = selDimension;
//	}


	
	

}
