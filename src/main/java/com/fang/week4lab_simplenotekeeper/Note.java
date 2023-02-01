/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fang.week4lab_simplenotekeeper;

import java.io.Serializable;

/**
 *
 * @author jifang
 */
public class Note implements Serializable {
    
    private String title;
    private String content;
    
    public Note() {
        title = "";
        content = "";
    }
    
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
}
