package com.entity;

public class MenuSecond {
    private Integer md_id;
    private String md_name;
    private Integer m_id;
    private String m_info;
	/**
	 * @return the md_id
	 */
	public Integer getMd_id() {
		return md_id;
	}
	/**
	 * @param md_id the md_id to set
	 */
	public void setMd_id(Integer md_id) {
		this.md_id = md_id;
	}
	/**
	 * @return the md_name
	 */
	public String getMd_name() {
		return md_name;
	}
	/**
	 * @param md_name the md_name to set
	 */
	public void setMd_name(String md_name) {
		this.md_name = md_name;
	}
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
	 * @return the m_info
	 */
	public String getM_info() {
		return m_info;
	}
	/**
	 * @param m_info the m_info to set
	 */
	public void setM_info(String m_info) {
		this.m_info = m_info;
	}
	public MenuSecond() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuSecond(Integer md_id, String md_name, Integer m_id, String m_info) {
		super();
		this.md_id = md_id;
		this.md_name = md_name;
		this.m_id = m_id;
		this.m_info = m_info;
	}
    
}
