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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "hdt_selDimensionEX")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class SelDimensionEX implements Serializable {

	private static final long serialVersionUID = 1L;

	@JSONField(serialize=false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id", unique = true, nullable = false)
	private long id;
	
	@JSONField(serialize=false)
	@Column(name = "_isDel")
	private int isDel;
	
	@Column(name = "_dimensionEx_id")
	private long dimensionEx_id;
	
	@Column(name = "_dimensionEx_name")
	private String dimensionEx_name;

	@JSONField(serialize=false)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dimensionExTemp_id")
	private DimensionExTemp dimensionExTemp;

	@JSONField(serialize=false)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "selDimension_id")
	private SelDimension selDimension;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getDimensionEx_name() {
		return dimensionEx_name;
	}

	public void setDimensionEx_name(String dimensionEx_name) {
		this.dimensionEx_name = dimensionEx_name;
	}

	public long getDimensionEx_id() {
		return dimensionEx_id;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public void setDimensionEx_id(long dimensionEx_id) {
		this.dimensionEx_id = dimensionEx_id;
	}

	public DimensionExTemp getDimensionExTemp() {
		return dimensionExTemp;
	}

	public void setDimensionExTemp(DimensionExTemp dimensionExTemp) {
		this.dimensionExTemp = dimensionExTemp;
	}

	public SelDimension getSelDimension() {
		return selDimension;
	}

	public void setSelDimension(SelDimension selDimension) {
		this.selDimension = selDimension;
	}

}
