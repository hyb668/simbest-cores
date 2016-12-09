package com.simbest.cores.app.model;

import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simbest.cores.model.GenericModel;
import com.simbest.cores.utils.annotations.NotNullColumn;

/**
 * 业务审批代理
 * 
 * @author lishuyi
 *
 */
@Entity
@Table(name = "app_process_agent")
@XmlRootElement
public class ProcessAgent extends GenericModel<ProcessAgent> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6018737319981211874L;

	@Id
	@Column(name = "agentId")
    @SequenceGenerator(name="app_process_agent_seq", sequenceName="app_process_agent_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="app_process_agent_seq")
	private Integer agentId;
	
	@NotNullColumn(value="业务类型")
	@Column(name = "typeId", nullable = false)
	private Integer typeId;
	
	@NotNullColumn(value="业务单据")
	@Column(name = "headerId", nullable = false)
	private Integer headerId;
	
	@Transient
	private String headerDesc;
	
	@Column(name = "userId", nullable = false)
	private Integer userId; 
	 
	@Column(name = "agentUserId", nullable = false)
	private Integer agentUserId;
	
	@Transient
	private String agentUserIds;
	
	@Column(name = "agentUserCode", nullable = false)
	private String agentUserCode;
	
	@Column(name = "agentUserName", nullable = false)
	private String agentUserName;
	
	@Temporal(TemporalType.DATE) 
	@Column(name = "beginDate", nullable = false)
	private Date beginDate;
	
	@Column(name = "expires", nullable = true)
	private Integer expires;
	
	@Column(name = "valid", nullable = false, columnDefinition = "int default 1")
	private Boolean valid;
	
	public ProcessAgent() {
		super();
	}

	/**
	 * 创建秘书或有时间限制的委托
	 * @param typeId
	 * @param headerId
	 * @param userId
	 * @param agentUserId
	 * @param agentUserCode
	 * @param agentUserName
	 * @param beginDate
	 * @param expires
	 */
	public ProcessAgent(Integer typeId, Integer headerId, Integer userId,
			Integer agentUserId, String agentUserCode, String agentUserName,
			Date beginDate, Integer expires) {
		super();
		this.typeId = typeId;
		this.headerId = headerId;
		this.userId = userId;
		this.agentUserId = agentUserId;
		this.agentUserCode = agentUserCode;
		this.agentUserName = agentUserName;
		this.beginDate = beginDate;
		this.expires = expires;
	}

	/**
	 * 查询有效的秘书或委托
	 * @param headerId
	 * @param userId
	 * @param valid
	 */
	public ProcessAgent(Integer headerId, Integer userId, Boolean valid) {
		super();
		this.headerId = headerId;
		this.userId = userId;
		this.valid = valid;
	}

	/**
	 * @return the agentId
	 */
	public Integer getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public Integer getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Integer headerId) {
		this.headerId = headerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the valid
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Integer getExpires() {
		return expires;
	}

	public void setExpires(Integer expires) {
		this.expires = expires;
	}

	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the agentUserId
	 */
	public Integer getAgentUserId() {
		return agentUserId;
	}

	/**
	 * @param agentUserId the agentUserId to set
	 */
	public void setAgentUserId(Integer agentUserId) {
		this.agentUserId = agentUserId;
	}

	/**
	 * @return the agentUserIds
	 */
	public String getAgentUserIds() {
		return agentUserIds;
	}

	/**
	 * @param agentUserIds the agentUserIds to set
	 */
	public void setAgentUserIds(String agentUserIds) {
		this.agentUserIds = agentUserIds;
	}

	/**
	 * @return the agentUserCode
	 */
	public String getAgentUserCode() {
		return agentUserCode;
	}

	/**
	 * @param agentUserCode the agentUserCode to set
	 */
	public void setAgentUserCode(String agentUserCode) {
		this.agentUserCode = agentUserCode;
	}

	/**
	 * @return the agentUserName
	 */
	public String getAgentUserName() {
		return agentUserName;
	}

	/**
	 * @param agentUserName the agentUserName to set
	 */
	public void setAgentUserName(String agentUserName) {
		this.agentUserName = agentUserName;
	}

	/**
	 * @return the headerDesc
	 */
	public String getHeaderDesc() {
		return headerDesc;
	}

	/**
	 * @param headerDesc the headerDesc to set
	 */
	public void setHeaderDesc(String headerDesc) {
		this.headerDesc = headerDesc;
	}

	
}