package com;

public class Entity {
	/*
	 * 发票代码
	 */
	private String fpdm;
	
	/*
	 * 发票号码
	 */
	private String fphm;
	
	/*
	 * 开票日期
	 */
	private String kprq;
	
	/*
	 * 客户名称
	 */
	private String khmc;
	
	/*
	 * 开票金额
	 */
	private String kpje;
	
	/*
	 * 作废标志
	 */
	private String zfbz;
	
	/*
	 * 数量
	 */
	private String sl;

	public String getFpdm() {
		return fpdm;
	}

	public void setFpdm(String fpdm) {
		this.fpdm = fpdm;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public String getKprq() {
		return kprq;
	}

	public void setKprq(String kprq) {
		this.kprq = kprq;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getKpje() {
		return kpje;
	}

	public void setKpje(String kpje) {
		this.kpje = kpje;
	}

	public String getZfbz() {
		return zfbz;
	}

	public void setZfbz(String zfbz) {
		this.zfbz = zfbz;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}
}
