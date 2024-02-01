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
        return dataRepository.findById(id).orElse(null);
        // メソッド名がfindOneからfindByIdに変わった
        // Optionalを返すようになったので取得できなかった場合の処理`.orElse(null)`を追加
    }

    public Data save(Data data) {
        return dataRepository.save(data);
    }

    public void delete(Long id) {
    	 // メソッド名がdeleteからdeleteByIdに変わった 
        dataRepository.deleteById(id);
    }
}