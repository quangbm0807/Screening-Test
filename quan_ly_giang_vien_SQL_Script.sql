CREATE DATABASE IF NOT EXISTS quan_ly_giang_vien;
USE quan_ly_giang_vien;
CREATE TABLE loai_giang_vien (
id INT PRIMARY KEY,
ten_loai VARCHAR(50) NOT NULL
);

CREATE TABLE trinh_do_hoc_van (
id INT PRIMARY KEY,
ten_trinh_do VARCHAR(30) NOT NULL
);
CREATE TABLE giang_vien (
ma_giang_vien VARCHAR(20) PRIMARY KEY,
ho_lot VARCHAR(30) NOT NULL,
ten VARCHAR(30) NOT NULL,
loai_giang_vien INT,
trinh_do_hoc_van INT,
hinh_anh VARCHAR(100),
luong_co_ban int NOT NULL,
ngay_bat_dau DATE NOT NULL,
FOREIGN KEY (loai_giang_vien) REFERENCES loai_giang_vien(id),
FOREIGN KEY (trinh_do_hoc_van) REFERENCES trinh_do_hoc_van(id)
);
INSERT INTO loai_giang_vien (id, ten_loai)
VALUES
(1, 'FULL_TIME'),
(2, 'PART_TIME');

INSERT INTO trinh_do_hoc_van (id, ten_trinh_do)
VALUES
(1, 'CU_NHAN_CAO_DANG'),
(2, 'CU_NHAN_DAI_HOC'),
(3, 'THAC_SY'),
(4, 'TIEN_SY');
INSERT INTO giang_vien (ma_giang_vien, ho_lot, ten, loai_giang_vien, trinh_do_hoc_van, hinh_anh, luong_co_ban, ngay_bat_dau)
VALUES
    ('anv123', 'Nguyen Van', 'A', 1, 4, 'nguyenvana.jpg', 15000000, '2020-01-15'),
    ('blt123', 'Le Thi', 'B', 2, 3, 'lethib.jpg', 12000000, '2021-03-10'),
    ('ctt123', 'Tran Thi', 'C', 1, 2, 'tranthic.jpg', 18000000, '2019-07-25'),
    ('dhv123', 'Hoang Van', 'D', 2, 1, 'hoangvand.jpg', 11000000, '2022-05-20');


