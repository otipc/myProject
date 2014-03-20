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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "hdt_selDimension")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class SelDimension implements Serializable {

	private static final long serialVersionUID = 1L;

	@JSONField(serialize=false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "_dimension_id")
	private long dimension_id;
	
	@Column(name = "_dimension_name")
	private String dimension_name;
	
	@JSONField(serialize=false)
	@Column(name = "_isDel")
	private int isDel;
		
	@JSONField(serialize=false)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dimensionTemp_id")
	private DimensionTemp dimensionTemp;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "selDimension")
	@OrderBy("id asc")
	private Set<SelDimensionEX> selDimensionEXs;

	@JSONField(serialize=false)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "taskSelSQL_id")
	private TaskSelSQL taskSelSQL;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDimension_name() {
		return dimension_name;
	}

	public void setDimension_name(String dimension_name) {
		this.dimension_name = dimension_name;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public long getDimension_id() {
		return dimension_id;
	}

	public void setDimension_id(long dimension_id) {
		this.dimension_id = dimension_id;
	}

	public Set<SelDimensionEX> getSelDimensionEXs() {
		return selDimensionEXs;
	}

	public void setSelDimensionEXs(Set<SelDimensionEX> selDimensionEXs) {
		this.selDimensionEXs = selDimensionEXs;
	}

	public TaskSelSQL getTaskSelSQL() {
		return taskSelSQL;
	}

	public void setTaskSelSQL(TaskSelSQL taskSelSQL) {
		this.taskSelSQL = taskSelSQL;
	}

	public DimensionTemp getDimensionTemp() {
		return dimensionTemp;
	}

	public void setDimensionTemp(DimensionTemp dimensionTemp) {
		this.dimensionTemp = dimensionTemp;
	}

}
