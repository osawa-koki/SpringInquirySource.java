package com.example.demo.dao;

import com.example.demo.entity.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class InquiryDaoImpl implements InquiryDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  // データベースからデータを取得する。
  @Override
  public void insertInquiry(Inquiry inquiry) {
    String sql = "";
    sql += " INSERT INTO inquery(name, email, contents, created) ";
    sql += " VALUES(?, ?, ?, ?) ";
    jdbcTemplate.update(sql, inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());
  }

  // エンティティにデータを詰め込む。
  @Override
  public List<Inquiry> getAll() {
    String sql = "";
    sql += " SELECT id, name, email, contents, created ";
    sql += " FROM inquiry ";
    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
    List<Inquiry> list = new ArrayList<Inquiry>();
    for (Map<String, Object> result: resultList) {
      Inquiry inquiry = new Inquiry();
      inquiry.setId((int)result.get("id"));
      inquiry.setName((String)result.get("name"));
      inquiry.setEmail((String)result.get("email"));
      inquiry.setContents((String)result.get("contents"));
      inquiry.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
      list.add(inquiry);
    }
    return list;
  }
}
