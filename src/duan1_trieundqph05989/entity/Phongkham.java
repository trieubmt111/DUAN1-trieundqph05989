package duan1_trieundqph05989.entity;
// Generated Aug 20, 2019 10:06:31 AM by Hibernate Tools 5.2.11.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Phongkham generated by hbm2java
 */
@Entity
@Table(name = "Phongkham", schema = "dbo", catalog = "qlpk_duan1", uniqueConstraints = @UniqueConstraint(columnNames = "Manv"))
public class Phongkham implements java.io.Serializable {

	private Integer maphongkham;
	private Nhanvien nhanvien;
	private String tenphongkham;
	private Set<Phieukham> phieukhams = new HashSet<Phieukham>(0);

	public Phongkham() {
	}

	public Phongkham(Nhanvien nhanvien, String tenphongkham) {
		this.nhanvien = nhanvien;
		this.tenphongkham = tenphongkham;
	}

	public Phongkham(Nhanvien nhanvien, String tenphongkham, Set<Phieukham> phieukhams) {
		this.nhanvien = nhanvien;
		this.tenphongkham = tenphongkham;
		this.phieukhams = phieukhams;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Maphongkham", unique = true, nullable = false)
	public Integer getMaphongkham() {
		return this.maphongkham;
	}

	public void setMaphongkham(Integer maphongkham) {
		this.maphongkham = maphongkham;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Manv", unique = true, nullable = false)
	public Nhanvien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	@Column(name = "Tenphongkham", nullable = false)
	public String getTenphongkham() {
		return this.tenphongkham;
	}

	public void setTenphongkham(String tenphongkham) {
		this.tenphongkham = tenphongkham;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phongkham")
	public Set<Phieukham> getPhieukhams() {
		return this.phieukhams;
	}

	public void setPhieukhams(Set<Phieukham> phieukhams) {
		this.phieukhams = phieukhams;
	}

}