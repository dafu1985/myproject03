package com.example.myproject03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproject03.domain.Data;
import com.example.myproject03.repository.DataRepository;

@Service
public class DataService {
    // ①@Autowiredを付けて宣言するとBeanをインジェクトしてくれるのでnewしなくても使うことができる
    @Autowired
    private DataRepository dataRepository;

    public List<Data> findAll() {
        return dataRepository.findAll();
    }

    public Data findOne(Long id) {
        return dataRepository.findOne(id);
    }

    public Data save(Data data) {
        return dataRepository.save(data);
    }

    public void delete(Long id) {
        dataRepository.deleteById(id);
    }
}