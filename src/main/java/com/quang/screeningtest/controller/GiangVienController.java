package com.quang.screeningtest.controller;

import com.quang.screeningtest.model.GiangVien;
import com.quang.screeningtest.service.GiangVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/giangvien")
@RequiredArgsConstructor
public class GiangVienController {

    private final GiangVienService giangVienService;

    @GetMapping
    public ResponseEntity<List<GiangVien>> getAllGiangViens() {
        List<GiangVien> giangViens = giangVienService.findAll();
        return ResponseEntity.ok(giangViens);
    }

    @GetMapping("/{maGiangVien}")
    public ResponseEntity<GiangVien> getGiangVienById(@PathVariable String maGiangVien) {
        Optional<GiangVien> giangVien = giangVienService.findById(maGiangVien);
        return giangVien.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<GiangVien> createGiangVien(@RequestBody GiangVien giangVien) {
        GiangVien savedGiangVien = giangVienService.save(giangVien);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGiangVien);
    }

    @PutMapping("/{maGiangVien}")
    public ResponseEntity<GiangVien> updateGiangVien(@PathVariable String maGiangVien,
                                                     @RequestBody GiangVien giangVien) {
        if (giangVienService.findById(maGiangVien).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        giangVien.setMaGiangVien(maGiangVien);
        GiangVien updatedGiangVien = giangVienService.save(giangVien);
        return ResponseEntity.ok(updatedGiangVien);
    }

    @PatchMapping("/{maGiangVien}")
    public ResponseEntity<GiangVien> patchGiangVien(@PathVariable String maGiangVien,
                                                    @RequestBody GiangVien giangVien) {
        Optional<GiangVien> existingGiangVien = giangVienService.findById(maGiangVien);
        if (existingGiangVien.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        GiangVien updatedGiangVien = existingGiangVien.get();
        if (giangVien.getHoLot() != null) {
            updatedGiangVien.setHoLot(giangVien.getHoLot());
        }
        if (giangVien.getTen() != null) {
            updatedGiangVien.setTen(giangVien.getTen());
        }
        if (giangVien.getLoaiGiangVien() != null) {
            updatedGiangVien.setLoaiGiangVien(giangVien.getLoaiGiangVien());
        }
        if (giangVien.getTrinhDoHocVan() != null) {
            updatedGiangVien.setTrinhDoHocVan(giangVien.getTrinhDoHocVan());
        }
        if (giangVien.getHinhAnh() != null) {
            updatedGiangVien.setHinhAnh(giangVien.getHinhAnh());
        }
        if (false) {
            updatedGiangVien.setLuongCoBan(giangVien.getLuongCoBan());
        }
        if (giangVien.getNgayBatDau() != null) {
            updatedGiangVien.setNgayBatDau(giangVien.getNgayBatDau());
        }
        GiangVien savedGiangVien = giangVienService.save(updatedGiangVien);
        return ResponseEntity.ok(savedGiangVien);
    }

    @DeleteMapping("/{maGiangVien}")
    public ResponseEntity<Void> deleteGiangVien(@PathVariable String maGiangVien) {
        if (giangVienService.findById(maGiangVien).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        giangVienService.deleteById(maGiangVien);
        return ResponseEntity.noContent().build();
    }
}
