package cn.hdtmedia.report.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.alibaba.fastjson.annotation.JSONField;


@Entity
@Table(name = "hdt_timerSelTask")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class TimerSelTask implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JSONField(serialize=false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id",unique=true, nullable = false)
	private long id;
	
	@Column(name = "_emailTo")
	private String emailTo;
	
	@Column(name = "_topic")
	private String topic;
	
	@Column(name = "_context")
	private String context;
	
	@Column(name = "_rate")
	private String rate;
	
	@Column(name = "_startTime")
	private Date startTime;

	@Column(name = "_endTime")
	private Date endTime;
	
	@JSONField(serialize=false)
	@Column(name = "_isDel")
	private int isDel;
	
	@JSONField(serialize=false)
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "taskSelSQL_id")
	private TaskSelSQL taskSelSQL;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public TaskSelSQL getTaskSelSQL() {
		return taskSelSQL;
	}

	public void setTaskSelSQL(TaskSelSQL taskSelSQL) {
		this.taskSelSQL = taskSelSQL;
	}

	

	
	
	
	
	
	
}
