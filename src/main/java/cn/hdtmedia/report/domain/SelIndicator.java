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
@Table(name = "hdt_selIndicator")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class SelIndicator implements Serializable {

	private static final long serialVersionUID = 1L;

	@JSONField(serialize=false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id", unique = true, nullable = false)
	private long id;
	
	@JSONField(serialize=false)
	@Column(name = "_isDel")
	private int isDel;
	
	@Column(name = "_indicator_id")
	private long indicator_id;
	
	@Column(name = "_indicator_name")
	private String indicator_name;

	@JSONField(serialize=false)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indicatorTemp_id")
	private IndicatorTemp indicatorTemp;

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
	
	public String getIndicator_name() {
		return indicator_name;
	}

	public void setIndicator_name(String indicator_name) {
		this.indicator_name = indicator_name;
	}

	public long getIndicator_id() {
		return indicator_id;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public void setIndicator_id(long indicator_id) {
		this.indicator_id = indicator_id;
	}

	public IndicatorTemp getIndicatorTemp() {
		return indicatorTemp;
	}

	public void setIndicatorTemp(IndicatorTemp indicatorTemp) {
		this.indicatorTemp = indicatorTemp;
	}

	public TaskSelSQL getTaskSelSQL() {
		return taskSelSQL;
	}

	public void setTaskSelSQL(TaskSelSQL taskSelSQL) {
		this.taskSelSQL = taskSelSQL;
	}

	
}
