package com.msober.domain.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.msober.domain.privilege.User;



/**
 * 所有实体的基类。
 * 
 */
@MappedSuperclass
public abstract class BaseEntity {
	/**
	 * 实体的唯一标示。
	 */
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * 创建时间。
	 */
	@Column
	private Date createTime;
	/**
	 * 最后修改时间。
	 */
	@Column
	private Date lastUpdateTime;
	/**
	 * 创建人。
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private User creator;
	
	/**
	 * 最后修改人。
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "last_updator_id")
	private User lastUpdator;

	public BaseEntity() {
		super();
	}

	public BaseEntity(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
/*
	@Override
	public String toString() {
		return getClass().getName() + "@" + Long.toString(id);
	}
*/
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getLastUpdator() {
		return lastUpdator;
	}

	public void setLastUpdator(User lastUpdator) {
		this.lastUpdator = lastUpdator;
	}

}
