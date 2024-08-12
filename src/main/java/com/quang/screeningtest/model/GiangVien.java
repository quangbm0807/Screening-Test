package com.quang.screeningtest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "giang_vien")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiangVien {

    @Id
    @Column(name = "ma_giang_vien", unique = true, nullable = false)
    private String maGiangVien;

    @Column(name = "ho_lot", nullable = false)
    private String hoLot;

    @Column(name = "ten", nullable = false)
    private String ten;

    @Column(name = "loai_giang_vien")
    private Integer loaiGiangVien;

    @Column(name = "trinh_do_hoc_van")
    private Integer trinhDoHocVan;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "luong_co_ban", nullable = false)
    private int luongCoBan;

    @Column(name = "ngay_bat_dau", nullable = false)
    private String ngayBatDau;
}
