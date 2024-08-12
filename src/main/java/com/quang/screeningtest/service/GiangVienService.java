package com.quang.screeningtest.service;

import com.quang.screeningtest.model.GiangVien;
import com.quang.screeningtest.repository.GiangVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GiangVienService {

    private final GiangVienRepository giangVienRepository;

    public List<GiangVien> findAll() {
        return giangVienRepository.findAll();
    }

    public Optional<GiangVien> findById(String maGiangVien) {
        return giangVienRepository.findById(maGiangVien);
    }

    public GiangVien save(GiangVien giangVien) {
        return giangVienRepository.save(giangVien);
    }

    public void deleteById(String maGiangVien) {
        giangVienRepository.deleteById(maGiangVien);
    }
}
