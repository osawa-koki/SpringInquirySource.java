package com.example.demo.dao;

import com.example.demo.entity.Inquiry;

import java.util.List;


public interface InquiryDao {
  void insertInquiry(Inquiry inquiry);

  // 実行時の影響を受けたレコード数を保存
  int updateInquiry(Inquiry inquiry);
  List<Inquiry> getAll();
}
