package com.example.myproject03.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // ①@EntityをつけることでDBのテーブルと紐づく
public class Data {
    @Id // ②@Idを付けた変数がテーブルのプライマーキーになる
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ③@GeneratedValueをつけると連番が自動で振られるようになる
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    @Min(value = 0)
    @Max(value = 150)
    private Integer age;
   @Size(max = 20)
    private String team;
    private String position;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Data [id=" + id + ", name=" + name + ", age=" + age + ", team=" + team + ", position=" + position + "]";
    }
}
