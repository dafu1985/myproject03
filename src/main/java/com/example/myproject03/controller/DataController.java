package com.example.myproject03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myproject03.domain.Data;
import com.example.myproject03.service.DataService;

@Controller
@RequestMapping("/datas") // ①クラスに対して@RequestMappingを付けておくと、クラス内のメソッド全てに適用される
//つまりこのクラスのメソッドは全て、http://localhost:8080/datasから始まるURLにマッピングされている
public class DataController {
    @Autowired
    private DataService dataService;

    @GetMapping
    public String index(Model model) { // ②メソッドの引数にModel型の値を設定するとModelのインスタンスが自動的に渡される
        List<Data> datas = dataService.findAll();
        model.addAttribute("datas", datas); // ③②で受け取ったmodelに値を詰めることで、テンプレートに値を渡すことができる
        //ここではdatasというキー名でdataのListを設定している
        return "datas/index"; // ④returnしている文字列を元に、src/main/resources/templates/配下からファイルを見つけてユーザに返している
        //ここではsrc/main/resources/templates/datas/index.htmlが返されている
    }

    @GetMapping("new")
    public String newData(Model model) {
    	//①:新規作成画面に対してPlayerインスタンスを渡すようにする
    	//これがないと入力エラー時に入力していた内容を保持することができない
    	//②:playerに@Validをつけることでvalidationチェック対象となる
    	//アノテーションを横並びにしているが@Validはplayerにかかっている
    	Data data = new Data();
    	model.addAttribute("Data", data);
        return "datas/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤メソッドの引数に@PathVariableを設定するとURL上の値を取得することができる
    	//ここでは、http://localhost/datas/1にアクセスされるとidには1が入る
        Data data = dataService.findOne(id);
        model.addAttribute("data", data);
        return "datas/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
    	Data data = dataService.findOne(id);
        model.addAttribute("data", data);
        //System.out.println(data);
        return "datas/show";
    }

    @PostMapping
    public String create(@Validated 
    		@ModelAttribute Data data, BindingResult bindingResult) { 
    	if(bindingResult.hasErrors()) return "datas/new";
    	dataService.save(data);
        return "redirect:/datas"; 
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @Validated 
    		@ModelAttribute Data data, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "datas/edit";
        data.setId(id);
        dataService.save(data);
        return "redirect:/datas";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        dataService.delete(id);
        return "redirect:/datas";
    }
}
