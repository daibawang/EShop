package com.entity;

public class MenuFirst {
    private Integer m_id;
    private String m_name;
	/**
	 * @return the m_id
	 */
	public Integer getM_id() {
		return m_id;
	}
	/**
	 * @param m_id the m_id to set
	 */
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	/**
	 * @return the m_name
	 */
	public String getM_name() {
		return m_name;
	}
	/**
	 * @param m_name the m_name to set
	 */
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public MenuFirst() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuFirst(Integer m_id, String m_name) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
	}
    

}
